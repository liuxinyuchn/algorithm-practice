package dynamic_programming;

// lc 940.不同的子序列 II
public class DistinctSubsequencesII {

    private static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int[] dp = new int[26];
        int all = 1;
        for (char c : s.toCharArray()) {
            int add = (all - dp[c - 'a'] + MOD) % MOD;
            dp[c - 'a'] = (dp[c - 'a'] + add) % MOD;
            all = (all + add) % MOD;
        }
        return (all - 1 + MOD) % MOD;
    }
}
