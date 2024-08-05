package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// lc 691.贴纸拼词
public class StickersToSpellWord {

    public int minStickers(String[] stickers, String target) {
        List<List<String>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        Set<String> visited = new HashSet<>();
        for (String str : stickers) {
            str = sort(str);
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
                    graph.get(str.charAt(i) - 'a').add(str);
                }
            }
        }
        target = sort(target);
        visited.add(target);
        Deque<String> queue = new LinkedList<>();
        queue.offer(target);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String s : graph.get(cur.charAt(0) - 'a')) {
                    String next = next(cur, s);
                    if (next.equals("")) {
                        return level;
                    } else if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    private String next(String t, String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        while (i < t.length()) {
            if (j == s.length()) {
                builder.append(t.charAt(i++));
            } else {
                if (t.charAt(i) < s.charAt(j)) {
                    builder.append(t.charAt(i++));
                } else if (t.charAt(i) > s.charAt(j)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return builder.toString();
    }
}
