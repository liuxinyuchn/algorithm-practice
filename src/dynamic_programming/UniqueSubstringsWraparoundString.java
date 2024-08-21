package dynamic_programming;

// lc 467.环绕字符串中唯一的子字符串
public class UniqueSubstringsWraparoundString {

    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.charAt(i) - 'a';
        }
        int[] dp = new int[26];
        dp[array[0]] = 1;
        for (int i = 1, len = 1; i < n; i++) {
            int cur = array[i];
            int pre = array[i - 1];
            if ((pre + 1) % 26 == cur) {
                len++;
            } else {
                len = 1;
            }
            dp[cur] = Math.max(dp[cur], len);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
