package dynamic_programming;

// lc 516.最长回文子序列
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] dp = new int[n];
        for (int l = n - 1, leftDown = 0, backup; l >= 0; l--) {
            dp[l] = 1;
            if (l + 1 < n) {
                leftDown = dp[l + 1];
                dp[l + 1] = c[l] == c[l + 1] ? 2 : 1;
            }
            for (int r = l + 2; r < n; r++) {
                backup = dp[r];
                if (c[l] == c[r]) {
                    dp[r] = 2 + leftDown;
                } else {
                    dp[r] = Math.max(dp[r], dp[r - 1]);
                }
                leftDown = backup;
            }
        }
        return dp[n - 1];
    }
}
