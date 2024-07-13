package monotonic_stack;

import java.util.Arrays;

// lc 316 去除重复字母
public class RemoveDuplicateLetters {

    private static final int[] cnts = new int[26];

    private static final boolean[] exists = new boolean[26];

    private static final char[] stack = new char[26];

    public String removeDuplicateLetters(String s) {
        int size = 0;
        Arrays.fill(cnts, 0);
        Arrays.fill(exists, false);
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (!exists[c - 'a']) {
                while (size > 0 && c < stack[size - 1] && cnts[stack[size - 1] - 'a'] > 0) {
                    exists[stack[--size] - 'a'] = false;
                }
                stack[size++] = c;
                exists[c - 'a'] = true;
            }
            cnts[c - 'a']--;
        }
        return String.valueOf(stack, 0, size);
    }
}
