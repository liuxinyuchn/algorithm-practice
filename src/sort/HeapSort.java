package sort;

import java.util.Arrays;

// 堆排序
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 2, 4, 0};
        System.out.println(Arrays.toString(topDownHeapSort(nums)));
        System.out.println(Arrays.toString(bottomUpHeapSort(nums)));
    }

    // 自顶向下
    public static int[] topDownHeapSort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            heapInsert(nums, i);
        }
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, size, 0);
        }
        return nums;
    }

    // 自底向顶
    public static int[] bottomUpHeapSort(int[] nums) {
        int size = nums.length;
        for (int i = size - 1; i >= 0; i--) {
            heapify(nums, size, i);
        }
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, size, 0);
        }
        return nums;
    }

    private static void heapInsert(int[] nums, int i) {
        while (nums[(i - 1) / 2] < nums[i]) {
            swap(nums, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private static void heapify(int[] nums, int size, int i) {
        int left = i * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && nums[left] < nums[left + 1] ? left + 1 : left;
            if (nums[i] > nums[largest]) {
                break;
            }
            swap(nums, largest, i);
            i = largest;
            left = i * 2 + 1;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
