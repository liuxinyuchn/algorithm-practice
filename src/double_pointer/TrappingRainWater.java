package double_pointer;

// lc 42.接雨水
public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0, leftMax = height[0], rightMax = height[height.length - 1], l = 1, r = height.length - 2;
        while (l <= r) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[l]);
                ans += leftMax - height[l++];
            } else {
                rightMax = Math.max(rightMax, height[r]);
                ans += rightMax - height[r--];
            }
        }
        return ans;
    }
}
