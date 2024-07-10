package binary_search;

import java.util.Arrays;

// lc 719.找出第 K 小的数对距离
public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, l = 0, r = nums[nums.length - 1] - nums[0];
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int pairCount = getPairCount(nums, m);
            if (pairCount >= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private int getPairCount(int[] nums, int distance) {
        int ans = 0;
        for (int i = 0, j = 0; i < nums.length - 1; i++) {
            while (j < nums.length - 1 && nums[j + 1] - nums[i] <= distance) {
                j++;
            }
            ans += j - i;
        }
        return ans;
    }
}
