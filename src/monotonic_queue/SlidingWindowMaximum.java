package monotonic_queue;

// lc 239.滑动窗口最大值
public class SlidingWindowMaximum {

    private static final int MAX = 100001;

    private static final int[] queue = new int[MAX];

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, head = 0, tail = 0;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            while (head < tail && nums[i] >= nums[queue[tail - 1]]) {
                tail--;
            }
            queue[tail++] = i;
        }
        for (int l = 0, r = k - 1; l < n - k + 1; l++, r++) {
            while (head < tail && nums[r] >= nums[queue[tail - 1]]) {
                tail--;
            }
            queue[tail++] = r;
            ans[l] = nums[queue[head]];
            if (l == queue[head]) {
                head++;
            }
        }
        return ans;
    }
}
