package sliding_window;

// lc 992.K 个不同整数的子数组
public class SubArraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysOfMostKDistinct(nums, k) - subarraysOfMostKDistinct(nums, k - 1);
    }

    private int subarraysOfMostKDistinct(int[] nums, int k) {
        int ans = 0;
        int[] cnt = new int[20001];
        for (int l = 0, r = 0, kind = 0; r < nums.length; r++) {
            if (cnt[nums[r]]++ == 0) {
                kind++;
            }
            while (kind > k) {
                if (cnt[nums[l++]]-- == 1) {
                    kind--;
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
