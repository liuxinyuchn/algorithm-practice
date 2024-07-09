package double_pointer;

// lc 922.按奇偶排序数组 Ⅱ
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0, odd = 1, n = nums.length;
        while (even < n && odd < n) {
            if ((nums[n - 1] & 1) == 1) {
                swap(nums, odd, n - 1);
                odd += 2;
            } else {
                swap(nums, even, n - 1);
                even += 2;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
