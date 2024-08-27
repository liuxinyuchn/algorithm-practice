package dfs;

// lc 329.矩阵中的最长递增路径
public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, memo, m, n, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] memo, int m, int n, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int ans = 0;
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            ans = Math.max(ans, dfs(matrix, memo, m, n, i - 1, j));
        }
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            ans = Math.max(ans, dfs(matrix, memo, m, n, i + 1, j));
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            ans = Math.max(ans, dfs(matrix, memo, m, n, i, j - 1));
        }
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            ans = Math.max(ans, dfs(matrix, memo, m, n, i, j + 1));
        }
        memo[i][j] = ans + 1;
        return ans + 1;
    }
}
