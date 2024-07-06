package sliding_window;

// lc 76.最小覆盖子串
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] hash = new int[58];
        for (char c : t.toCharArray()) {
            hash[c - 'A']--;
        }
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        for (int l = 0, r = 0, cnt = 0; r < s.length(); r++) {
            if (hash[s.charAt(r) - 'A']++ < 0) {
                cnt++;
            }
            if (cnt == t.length()) {
                while (hash[s.charAt(l) - 'A'] > 0) {
                    hash[s.charAt(l++) - 'A']--;
                }
                if (r - l + 1 < minLength) {
                    start = l;
                    minLength = r - l + 1;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
