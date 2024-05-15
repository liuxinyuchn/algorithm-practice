package search.binary;

// lc 162. 寻找峰值
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int l = 1, r = n - 2, ans = l;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < nums[m - 1]) {
                r = m - 1;
            } else if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }
}
