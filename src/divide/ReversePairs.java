package divide;

// lc 493.翻转对
public class ReversePairs {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 3, 1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        return counts(nums, tmp, 0, n - 1);
    }

    private static int counts(int[] nums, int[] tmp, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        int leftCount = counts(nums, tmp, l, m);
        int rightCount = counts(nums, tmp, m + 1, r);
        int mergeCount = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) nums[i] > (long) nums[j] * 2) {
                j++;
            }
            mergeCount += j - m - 1;
        }
        int i = l, a= l, b = m + 1;
        while (a <= m && b <= r) {
            tmp[i++] = nums[a] <= nums[b] ? nums[a++] : nums[b++];
        }
        while (a <= m) {
            tmp[i++] = nums[a++];
        }
        while (b <= r) {
            tmp[i++] = nums[b++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = tmp[i];
        }
        return leftCount + rightCount + mergeCount;
    }
}
