package union_find;

import java.util.Arrays;

// lc 2421.好路径的数目
public class NumberOfGoodPaths {

    private static final int MAX_SIZE = 30001;

    private static final int[] father = new int[MAX_SIZE];

    private static final int[] maxCnts = new int[MAX_SIZE];

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length, ans = n;
        build(n);
        Arrays.sort(edges, (a, b) -> Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]));
        for (int[] edge : edges) {
            ans += union(edge[0], edge[1], vals);
        }
        return ans;
    }

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            maxCnts[i] = 1;
        }
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private int union(int i, int j, int[] vals) {
        int fi = find(i), fj = find(j), path = 0;
        if (vals[fi] > vals[fj]) {
            father[fj] = fi;
        } else if (vals[fi] < vals[fj]) {
            father[fi] = fj;
        } else {
            path = maxCnts[fi] * maxCnts[fj];
            father[fi] = fj;
            maxCnts[fj] += maxCnts[fi];
        }
        return path;
    }
}
