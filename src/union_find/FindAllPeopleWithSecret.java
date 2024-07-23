package union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 2092.找出知晓秘密的所有专家
public class FindAllPeopleWithSecret {

    private static final int MAX_SIZE = 100001;

    private static final int[] father = new int[MAX_SIZE];

    private static final boolean[] secret = new boolean[MAX_SIZE];

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        build(n, firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        for (int l = 0; l < meetings.length; ) {
            int r = l;
            while (r + 1 < meetings.length && meetings[r + 1][2] == meetings[l][2]) {
                r++;
            }
            for (int i = l; i <= r; i++) {
                union(meetings[i][0], meetings[i][1]);
            }
            for (int i = l; i <= r; i++) {
                int a = meetings[i][0];
                int b = meetings[i][1];
                if (!secret[find(a)]) {
                    father[a] = a;
                }
                if (!secret[find(b)]) {
                    father[b] = b;
                }
            }
            l = r + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[find(i)]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void build(int n, int firstPerson) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            secret[i] = false;
        }
        father[firstPerson] = 0;
        secret[0] = true;
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void union(int i, int j) {
        int fi = find(i);
        int fj = find(j);
        if (fi != fj) {
            father[fi] = fj;
            secret[fj] |= secret[fi];
        }
    }
}
