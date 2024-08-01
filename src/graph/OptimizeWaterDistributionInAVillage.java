package graph;

import java.util.Arrays;

// lc 1168.水资源分配优化
public class OptimizeWaterDistributionInAVillage {

    private static final int MAX_SIZE = 10001;

    private static final int[] father = new int[MAX_SIZE];

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        build(n);
        int m = pipes.length, index = 0;
        int[][] allPipes = new int[m + n][3];
        for (int i = 0; i < n; i++) {
            allPipes[index++] = new int[]{0, i + 1, wells[i]};
        }
        for (int[] pipe : pipes) {
            allPipes[index++] = pipe;
        }
        Arrays.sort(allPipes, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for (int[] pipe : allPipes) {
            if (union(pipe[0], pipe[1])) {
                ans += pipe[2];
            }
        }
        return ans;
    }

    private void build(int n) {
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }

    private int find(int i) {
        if (father[i] != i) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            return true;
        }
        return false;
    }
}
