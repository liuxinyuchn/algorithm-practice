package sort;

import java.util.Arrays;

// 插入排序
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    // 0 ~ i 范围上已经有序，新来的数从右到左滑到不再小的位置插入，然后继续
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
            }
        }
        return nums;
    }
}
