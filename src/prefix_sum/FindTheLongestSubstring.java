package prefix_sum;

import java.util.Arrays;

// lc 1371.每个元音包含偶数次的最长子字符串
public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int ans = 0;
        int[] hash = new int[32];
        Arrays.fill(hash, -2);
        hash[0] = -1;
        for (int i = 0, find = 0; i < s.length(); i++) {
            int bit = getBit(s.charAt(i));
            if (bit >= 0) {
                find ^= (1 << bit);
            }
            if (hash[find] != -2) {
                ans = Math.max(ans, i - hash[find]);
            } else {
                hash[find] = i;
            }
        }
        return ans;
    }

    private int getBit(char c) {
        return switch (c) {
            case 'a' -> 4;
            case 'e' -> 3;
            case 'i' -> 2;
            case 'o' -> 1;
            case 'u' -> 0;
            default -> -1;
        };
    }
}
