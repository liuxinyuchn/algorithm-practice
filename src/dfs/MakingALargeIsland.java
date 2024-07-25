package dfs;

// lc 827.最大人工岛
public class MakingALargeIsland {

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0, id = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, m, n, i, j, id++);
                }
            }
        }
        int[] sizes = new int[id];
        for (int[] row : grid) {
            for (int i = 0; i < n; i++) {
                if (row[i] > 1) {
                    ans = Math.max(ans, ++sizes[row[i]]);
                }
            }
        }
        boolean[] hasCounted = new boolean[id];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int up = i == 0 ? 0 : grid[i - 1][j];
                    int down = i == m - 1 ? 0 : grid[i + 1][j];
                    int left = j == 0 ? 0 : grid[i][j - 1];
                    int right = j == n - 1 ? 0 : grid[i][j + 1];
                    int count = 1 + sizes[up];
                    hasCounted[up] = true;
                    if (!hasCounted[down]) {
                        count += sizes[down];
                        hasCounted[down] = true;
                    }
                    if (!hasCounted[left]) {
                        count += sizes[left];
                        hasCounted[left] = true;
                    }
                    if (!hasCounted[right]) {
                        count += sizes[right];
                        hasCounted[right] = true;
                    }
                    ans = Math.max(ans, count);
                    hasCounted[up] = false;
                    hasCounted[down] = false;
                    hasCounted[left] = false;
                    hasCounted[right] = false;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int m, int n, int i, int j, int id) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = id;
        dfs(grid, m, n, i - 1, j, id);
        dfs(grid, m, n, i + 1, j, id);
        dfs(grid, m, n, i, j - 1, id);
        dfs(grid, m, n, i, j + 1, id);
    }
}
