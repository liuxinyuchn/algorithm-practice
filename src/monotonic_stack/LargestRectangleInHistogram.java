package monotonic_stack;

// lc 84.柱状图中的最大矩形
public class LargestRectangleInHistogram {

    private static final int MAX = 10001;

    private static final int[] stack = new int[MAX];

    public int largestRectangleArea(int[] heights) {
        int ans = 0, size = 0, n = heights.length;
        for (int i = 0; i < n; i++) {
            while (size > 0 && heights[i] <= heights[stack[size - 1]]) {
                int cur = stack[--size];
                int left = size > 0 ? stack[size - 1] : -1;
                ans = Math.max(ans, (i - left - 1) * heights[cur]);
            }
            stack[size++] = i;
        }
        while (size > 0) {
            int cur = stack[--size];
            int left = size > 0 ? stack[size - 1] : -1;
            ans = Math.max(ans, (n - left - 1) * heights[cur]);
        }
        return ans;
    }
}
