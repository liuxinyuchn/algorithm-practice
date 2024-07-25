package dfs;

// lc 803.打砖块
public class BricksFallingWhenHit {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length, h = hits.length;
        int[] ans = new int[h];
        if (m == 1) {
            return ans;
        }
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, m, n, 0, j);
        }
        for (int k = h - 1; k >= 0; k--) {
            int i = hits[k][0], j = hits[k][1];
            grid[i][j]++;
            if (worth(grid, m, n, i, j)) {
                ans[k] = dfs(grid, m, n, i, j) - 1;
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(grid, m, n, i - 1, j)
                + dfs(grid, m, n, i + 1, j)
                + dfs(grid, m, n, i, j - 1)
                + dfs(grid, m, n, i, j + 1);
    }

    private boolean worth(int[][] grid, int m, int n, int i, int j) {
        return grid[i][j] == 1
                &&
                (i == 0
                || (grid[i - 1][j]== 2)
                || (i < m - 1 && grid[i + 1][j] == 2)
                || (j > 0 && grid[i][j - 1] == 2)
                || (j < n - 1 && grid[i][j + 1] == 2));
    }
}
