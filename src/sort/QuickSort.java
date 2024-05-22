package sort;

import java.util.Arrays;

// 快速排序
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int random = nums[l + (int) (Math.random() * (r - l + 1))];
        int i = l, a = l, b = r;
        while (i <= b) {
            if (nums[i] < random) {
                swap(nums, i++, a++);
            } else if (nums[i] > random) {
                swap(nums, i, b--);
            } else {
                i++;
            }
        }
        sort(nums, l, a - 1);
        sort(nums, b + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
