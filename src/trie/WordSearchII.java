package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 212.单词搜索Ⅱ
public class WordSearchII {

    private static final int MAXN = 10001;

    private static final int[][] tree = new int[MAXN][26];

    private static final int[] pass = new int[MAXN];

    private static final String[] end = new String[MAXN];

    private static int cnt;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        build(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, 1, result);
            }
        }
        return result;
    }

    private int dfs(char[][] board, int i, int j, int t, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 0) {
            return 0;
        }
        char c = board[i][j];
        int cur = tree[t][c - 'a'];
        if (pass[cur] == 0) {
            return 0;
        }
        int ans = 0;
        if (end[cur] != null) {
            ans++;
            result.add(end[cur]);
            end[cur] = null;
        }
        board[i][j] = 0;
        ans += dfs(board, i - 1, j, cur, result);
        ans += dfs(board, i + 1, j, cur, result);
        ans += dfs(board, i, j - 1, cur, result);
        ans += dfs(board, i, j + 1, cur, result);
        board[i][j] = c;
        pass[cur] -= ans;
        return ans;
    }

    private void build(String[] words) {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = null;
        }
        cnt = 1;
        for (String word : words) {
            insert(word);
        }
    }

    private void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (char c : word.toCharArray()) {
            int path = c - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur] = word;
    }
}
