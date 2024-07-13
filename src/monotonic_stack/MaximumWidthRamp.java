package monotonic_stack;

// lc 962.最大宽度坡
public class MaximumWidthRamp {

    private static final int MAX = 50001;

    private static final int[] stack = new int[MAX];

    public int maxWidthRamp(int[] nums) {
        int ans = 0, size = 1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[stack[size - 1]]) {
                stack[size++] = i;
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            while (size > 0 && nums[j] >= nums[stack[size - 1]]) {
                ans = Math.max(ans, j - stack[--size]);
            }
        }
        return ans;
    }
}
