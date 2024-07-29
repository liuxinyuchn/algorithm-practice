package graph;

import java.util.Arrays;

// lc 269.火星词典
public class AlienDictionary {

    public String alienOrder(String[] words) {
        int[] head = new int[26];
        int[] next = new int[52];
        int[] to = new int[52];
        int size = 1;
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree[c - 'a'] = 0;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String curWord = words[i], nextWord = words[i + 1];
            int j = 0, len = Math.min(curWord.length(), nextWord.length());
            while (j < len) {
                char curChar = curWord.charAt(j), nextChar = nextWord.charAt(j);
                if (curChar != nextChar) {
                    next[size] = head[curChar - 'a'];
                    to[size] = nextChar - 'a';
                    head[curChar - 'a'] = size++;
                    indegree[nextChar - 'a']++;
                    break;
                }
                j++;
            }
            if (j < curWord.length() && j == nextWord.length()) {
                return "";
            }
        }
        int[] queue = new int[26];
        int l = 0, r = 0, cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (indegree[i] != -1) {
                cnt++;
            }
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (l < r) {
            int cur = queue[l++];
            builder.append((char) (cur + 'a'));
            for (int e = head[cur]; e > 0; e = next[e]) {
                if (--indegree[to[e]] == 0) {
                    queue[r++] = to[e];
                }
            }
        }
        return builder.length() == cnt ? builder.toString() : "";
    }
}
