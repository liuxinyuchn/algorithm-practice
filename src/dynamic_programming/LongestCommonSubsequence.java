package dynamic_programming;

// lc 1143.最长公共子序列
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1, c2;
        if (text1.length() > text2.length()) {
            c1 = text1.toCharArray();
            c2 = text2.toCharArray();
        } else {
            c1 = text2.toCharArray();
            c2 = text1.toCharArray();
        }
        int m = c1.length, n = c2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0], backup = 0;
            for (int j = 1; j <= n; j++) {
                backup = dp[j];
                if (c1[i - 1] == c2[j - 1]) {
                    dp[j] = leftUp + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftUp = backup;
            }
        }
        return dp[n];
    }
}
