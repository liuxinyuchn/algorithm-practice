package monotonic_queue;

// lc 862.和至少为 K 的最短子数组
public class ShortestSubarrayWithSumAtLeastK {

    private static final int MAX = 100001;

    private static final long[] sum = new long[MAX];

    private static final int[] queue = new int[MAX];

    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, head = 0, tail = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            while (head < tail && sum[i] - sum[queue[head]] >= k) {
                ans = Math.min(ans, i - queue[head++]);
            }
            while (head < tail && sum[i] <= sum[queue[tail - 1]]) {
                tail--;
            }
            queue[tail++] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
