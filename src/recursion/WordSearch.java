package recursion;

// lc 79.单词搜索
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, target, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, char[] target, int i, int j, int k) {
        if (k == target.length) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != target[k]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        boolean result = check(board, target, i - 1, j, k + 1)
            || check(board, target, i + 1, j, k + 1)
            || check(board, target, i, j - 1, k + 1)
            || check(board, target, i, j + 1, k + 1);
        board[i][j] = tmp;
        return result;
    }
}
