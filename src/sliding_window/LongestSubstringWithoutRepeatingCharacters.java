package sliding_window;

import java.util.HashMap;
import java.util.Map;

// lc 3.无重复字符的最长字串
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        int ans = 0;
        for (int l = 0, r = 0; r < sArray.length; r++) {
            l = Math.max(l, map.getOrDefault(sArray[r], -1) + 1);
            ans = Math.max(ans, r - l + 1);
            map.put(sArray[r], r);
        }
        return ans;
    }
}
