package dynamic_programming;

// lc 639.解码方法 II
public class DecodeWaysII {

    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = (s.charAt(i) == '*' ? 9 : 1) * dp[i + 1];
                if (i + 1 < n) {
                    if (s.charAt(i) != '*') {
                        if (s.charAt(i + 1) != '*') {
                            if ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            if (s.charAt(i) == '1') {
                                dp[i] += 9 * dp[i + 2];
                            }
                            if (s.charAt(i) == '2') {
                                dp[i] += 6 * dp[i + 2];
                            }
                        }
                    } else {
                        if (s.charAt(i + 1) != '*') {
                            if (s.charAt(i + 1) <= '6') {
                                dp[i] += 2 * dp[i + 2];
                            } else {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            dp[i] += 15 * dp[i + 2];
                        }
                    }
                }
                dp[i] %= MOD;
            }
        }
        return (int) dp[0];
    }
}
