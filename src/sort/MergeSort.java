package sort;

import java.util.Arrays;

// 归并排序
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(recursiveSort(nums)));
        System.out.println(Arrays.toString(nonRecursiveSort(nums)));
    }

    // 递归解法
    public static int[] recursiveSort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, tmp, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int[] tmp, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        sort(nums, tmp, l, m);
        sort(nums, tmp, m + 1, r);
        merge(nums, tmp, l, r, m);
    }

    // 非递归解法
    public static int[] nonRecursiveSort(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int step = 1; step < nums.length; step <<= 1) {
            int l = 0;
            while (l < nums.length) {
                int m = l + step - 1;
                if (m + 1 >= nums.length) {
                    break;
                }
                int r = Math.min(m + step, nums.length - 1);
                merge(nums, tmp, l, r, m);
                l = r + 1;
            }
        }
        return nums;
    }

    private static void merge(int[] nums, int[] tmp, int l, int r, int m) {
        int i = l;
        int a = l;
        int b = m + 1;
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
    }
}
