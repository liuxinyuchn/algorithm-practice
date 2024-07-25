package dfs;

// lc 130.被围绕的区域
public class SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, m, n, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, m, n, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, m, n, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m, n, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'F';
        dfs(board, m, n, i - 1, j);
        dfs(board, m, n, i + 1, j);
        dfs(board, m, n, i, j - 1);
        dfs(board, m, n, i, j + 1);
    }
}
