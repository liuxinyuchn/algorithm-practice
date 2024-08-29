package dynamic_programming;

// lc 474.一和零
public class OnesAndZeroes {

    private int oneCount;

    private int zeroCount;

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            countOneAndZero(str);
            for (int z = m; z >= zeroCount; z--) {
                for (int o = n; o >= oneCount; o--) {
                    dp[z][o] = Math.max(dp[z][o], dp[z - zeroCount][o - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private void countOneAndZero(String str) {
        oneCount = zeroCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
    }
}
