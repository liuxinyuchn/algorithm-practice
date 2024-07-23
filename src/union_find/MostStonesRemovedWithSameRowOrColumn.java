package union_find;

import java.util.HashMap;
import java.util.Map;

// lc 947.移除最多的同行或同列石头
public class MostStonesRemovedWithSameRowOrColumn {

    private static final int MAX_SIZE = 1001;

    private static final int[] father = new int[MAX_SIZE];

    private static int size;

    private static final Map<Integer, Integer> columnMark = new HashMap<>();

    private static final Map<Integer, Integer> rowMark = new HashMap<>();

    public int removeStones(int[][] stones) {
        int n = stones.length;
        build(n);
        for (int i = 0; i < n; i++) {
            int x = stones[i][0], y = stones[i][1];
            if (columnMark.containsKey(x)) {
                union(i, columnMark.get(x));
            } else {
                columnMark.put(x, i);
            }
            if (rowMark.containsKey(y)) {
                union(i, rowMark.get(y));
            } else {
                rowMark.put(y, i);
            }
        }
        return n - size;
    }

    private void build(int n) {
        columnMark.clear();
        rowMark.clear();
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
