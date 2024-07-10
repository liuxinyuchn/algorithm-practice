package binary_search;

// lc 410.分割数组最大值
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int ans = 0, l = 0, r = sum;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int splitCount = getSplitCount(nums, m);
            if (splitCount <= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private int getSplitCount(int[] nums, int limit) {
        int ans = 1, sum = 0;
        for (int num : nums) {
            if (num > limit) {
                return Integer.MAX_VALUE;
            }
            if (sum + num > limit) {
                ans++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return ans;
    }
}
