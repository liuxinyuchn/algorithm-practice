package dynamic_programming;

// lc 72.编辑距离
public class EditDistance {

    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray(), c2 = word2.toCharArray();
        int m = c1.length, n = c2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int leftUp = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int backup = dp[j];
                if (c1[i - 1] == c2[j - 1]) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = Math.min(leftUp, Math.min(dp[j], dp[j - 1])) + 1;
                }
                leftUp = backup;
            }
        }
        return dp[n];
    }
}
