package dynamic_programming;

// lc 264.丑数 II
public class UglyNumberII {
    
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2, a = 1, b = 1, c = 1; i <= n; i++) {
            int ai = dp[a] * 2;
            int bi = dp[b] * 3;
            int ci = dp[c] * 5;
            dp[i] = Math.min(ai, Math.min(bi, ci));
            if (dp[i] == ai) {
                a++;
            }
            if (dp[i] == bi) {
                b++;
            }
            if (dp[i] == ci) {
                c++;
            }
        }
        return dp[n];
    }
}
