package dfs;

// lc 200.岛屿数量
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, m, n, i - 1, j);
        dfs(grid, m, n, i + 1, j);
        dfs(grid, m, n, i, j - 1);
        dfs(grid, m, n, i, j + 1);
    }
}
