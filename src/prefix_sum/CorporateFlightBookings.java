package prefix_sum;

// lc 1109.航班预定统计
public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefixSums = new int[n + 2];
        for (int[] booking : bookings) {
            prefixSums[booking[0]] += booking[2];
            prefixSums[booking[1] + 1] -= booking[2];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] += prefixSums[i];
            ans[i] = prefixSums[i + 1];
        }
        return ans;
    }
}
