package sort;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    // 0 ~ i 范围上，相邻位置较大的数滚下去，最大值最终来到 i 位置，然后 0 ~ i-1 范围上继续
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                }
            }
        }
        return nums;
    }
}
