package union_find;

// lc 839.相似字符串组
public class SimilarStringGroups {

    private static final int MAX_SIZE = 301;

    private static final int[] father = new int[MAX_SIZE];

    private static int size;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int strLength = strs[0].length();
        build(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (find(i) != find(j)) {
                    int diff = 0;
                    for (int k = 0; diff < 3 && k < strLength; k++) {
                        if (strs[i].charAt(k) != strs[j].charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff == 0 || diff == 2) {
                        union(i, j);
                    }
                }
            }
        }
        return size;
    }

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        size = n;
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
            size--;
        }
    }
}
