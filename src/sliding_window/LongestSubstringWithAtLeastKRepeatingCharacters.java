package sliding_window;

import java.util.Arrays;

// lc 395.至少有 K 个重复字符的最长子串
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        int ans = 0, n = s.length();
        int[] cnt = new int[26];
        char[] sArray = s.toCharArray();
        for (int require = 1; require <= 26; require++) {
            Arrays.fill(cnt, 0);
            for (int l = 0, r = 0, collect = 0, satisfaction = 0; r < n; r++) {
                if (cnt[sArray[r] - 'a']++ == 0) {
                    collect++;
                }
                if (cnt[sArray[r] - 'a'] == k) {
                    satisfaction++;
                }
                while (collect > require) {
                    if (cnt[sArray[l] - 'a'] == 1) {
                        collect--;
                    }
                    if (cnt[sArray[l] - 'a'] == k) {
                        satisfaction--;
                    }
                    cnt[sArray[l++] - 'a']--;
                }
                if (satisfaction == require) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }
}
