package dynamic_programming;

// lc 983.最低票价
public class MinCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] durations = {1, 7, 30};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0, j = i; k < 3; k++) {
                while (j < n && days[i] + durations[k] > days[j]) {
                    j++;
                }
                dp[i] = Math.min(dp[i], dp[j] + costs[k]);
            }
        }
        return dp[0];
    }
}
