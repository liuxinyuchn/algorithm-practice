package sort;

import java.util.Arrays;

// 选择排序
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    // i ~ n-1 范围上，找到最小值并放在 i 位置，然后 i+1 ~ n-1 范围上继续
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}
