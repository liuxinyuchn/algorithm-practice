package dynamic_programming;

// lc 97.交错字符串
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        boolean[] dp = new boolean[n + 1];
        for (int j = 0; j <= n; j++) {
            if (j > 0 && c2[j - 1] != c3[j - 1]) {
                break;
            }
            dp[j] = true;
        }
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && c1[i - 1] == c3[i - 1];
            for (int j = 1; j <= n; j++) {
                dp[j] = (dp[j - 1] && c2[j - 1] == c3[i + j - 1]) || (dp[j] && c1[i - 1] == c3[i + j - 1]);
            }
        }
        return dp[n];
    }
}
