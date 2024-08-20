package dynamic_programming;

// lc 639.解码方法 II
public class DecodeWaysII {

    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = checkOneDigit(s.charAt(i)) * dp[i + 1];
            if (i + 1 < n) {
                dp[i] += checkTwoDigit(s.charAt(i), s.charAt(i + 1)) * dp[i + 2];
            }
            dp[i] %= MOD;
        }
        return (int) dp[0];
    }

    private int checkOneDigit(char c) {
        if (c == '0') {
            return 0;
        }
        return c == '*' ? 9 : 1;
    }

    private int checkTwoDigit(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c1 == '*') {
            return c2 <= '6' ? 2 : 1;
        }
        if (c2 == '*') {
            if (c1 == '1') {
                return 9;
            }
            if (c1 == '2') {
                return 6;
            }
            return 0;
        }
        return (c1 != '0' && (c1 - '0') * 10 + c2 - '0' <= 26) ? 1 : 0; 
    }
}
