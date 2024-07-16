package monotonic_queue;

// lc 1438.绝对差不超过限制的最长连续子数组
public class LongestSubarrayAbsoluteLimit {

    private static final int MAX = 100001;

    private static final int[] minQueue = new int[MAX];

    private static final int[] maxQueue = new int[MAX];

    private static int minHead, minTail, maxHead, maxTail;

    public int longestSubarray(int[] nums, int limit) {
        int ans = 0, n = nums.length;
        minHead = minTail = maxHead = maxTail = 0;
        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && satisfy(nums, limit, nums[r])) {
                push(nums, r++);
            }
            ans = Math.max(ans, r - l);
            pop(l);
        }
        return ans;
    }

    private boolean satisfy(int[] nums, int limit, int num) {
        int max = maxHead < maxTail ? Math.max(nums[maxQueue[maxHead]], num) : num;
        int min = minHead < minTail ? Math.min(nums[minQueue[minHead]], num) : num;
        return max - min <= limit;
    }

    private void push(int[] nums, int index) {
        while (minHead < minTail && nums[index] <= nums[minQueue[minTail - 1]]) {
            minTail--;
        }
        minQueue[minTail++] = index;
        while (maxHead < maxTail && nums[index] >= nums[maxQueue[maxTail - 1]]) {
            maxTail--;
        }
        maxQueue[maxTail++] = index;
    }

    private void pop(int index) {
        if (minHead < minTail && index == minQueue[minHead]) {
            minHead++;
        }
        if (maxHead < maxTail && index == maxQueue[maxHead]) {
            maxHead++;
        }
    }
}
