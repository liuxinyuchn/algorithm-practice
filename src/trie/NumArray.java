package trie;

// lc 303.区域和检索 - 数组不可变
public class NumArray {

    private static int[] sums;

    // 使用数组 nums 初始化对象
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1, sum = 0; i <= nums.length; i++) {
            sum += nums[i - 1];
            sums[i] = sum;
        }
    }

    // 返回数组 nums 中索引 left 和 right 之间的元素的总和 ，包含 left 和 right 两点
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
