package trie;

import java.util.Arrays;

// lc 1804.实现 Trie（前缀树）Ⅱ
public class Trie {

    private static final int MAX = 52001;

    private static final int[][] tree = new int[MAX][26];

    private static final int[] pass = new int[MAX];

    private static final int[] end = new int[MAX];

    private static int cnt = 1;

    // 初始化前缀树对象
    public Trie() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = 0;
        }
        cnt = 1;
    }

    // 将字符串 word 插入前缀树中
    public void insert(String word) {
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
        end[cur]++;
    }

    // 返回前缀树中字符串 word 的实例个数
    public int countWordsEqualTo(String word) {
        int cur = 1;
        for (char c : word.toCharArray()) {
            int path = c - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return end[cur];
    }

    // 返回前缀树中以 prefix 为前缀的字符串个数
    public int countWordsStartingWith(String prefix) {
        int cur = 1;
        for (char c : prefix.toCharArray()) {
            int path = c - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    // 从前缀树中移除字符串 word
    public void erase(String word) {
        if (countWordsEqualTo(word) == 0) {
            return;
        }
        int cur = 1;
        for (char c : word.toCharArray()) {
            int path = c - 'a';
            if (--pass[tree[cur][path]] == 0) {
                tree[cur][path] = 0;
                return;
            }
            cur = tree[cur][path];
        }
        end[cur]--;
    }
}
