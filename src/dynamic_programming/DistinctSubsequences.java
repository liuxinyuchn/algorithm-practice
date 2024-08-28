package dynamic_programming;

// lc 115.不同的子序列
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int m = sArray.length, n = tArray.length, mod = 1000000007;;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (sArray[i - 1] == tArray[j - 1]) {
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
                }
            }
        }
        return dp[n];
    }
}
