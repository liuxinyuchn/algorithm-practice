package union_find;

// lc 765.情侣牵手
public class CoupleHoldingHands {

    private static final int MAX_SIZE = 31;

    private static final int[] father = new int[MAX_SIZE];

    private static int setSize;

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        build(n / 2);
        for (int i = 0; i < n; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        return n / 2 - setSize;
    }

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        setSize = n;
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
            setSize--;
        }
    }
}
