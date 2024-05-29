package sort;

import java.util.Arrays;

// 基数排序
public class RadixSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(sort(nums)));
    }

    private static int[] sort(int[] nums) {
        int n = nums.length;
        int base = 10;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] -= min;
            max = Math.max(nums[i], max);
        }
        int maxBit = 0;
        while (max > 0) {
            maxBit++;
            max /= base;
        }
        int[] tmp = new int[n];
        int[] count = new int[base];
        for (int offset = 1; maxBit > 0; maxBit--, offset *= base) {
            Arrays.fill(count, 0);
            for (int num : nums) {
                count[(num / offset) % base]++;
            }
            for (int i = 1; i < base; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                tmp[--count[(nums[i] / offset) % base]] = nums[i];
            }
            System.arraycopy(tmp, 0, nums, 0, n);
        }
        for (int i = 0; i < n; i++) {
            nums[i] += min;
        }
        return nums;
    }

}
