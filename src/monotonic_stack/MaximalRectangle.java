package monotonic_stack;

import java.util.Arrays;

// lc 85.最大矩形
public class MaximalRectangle {

    private static final int MAX = 201;

    private static final int[] stack = new int[MAX];

    private static final int[] array = new int[MAX];

    public int maximalRectangle(char[][] matrix) {
        int ans = 0, m = matrix.length, n = matrix[0].length;
        Arrays.fill(array, 0, n, 0);
        for (char[] row : matrix) {
            for (int i = 0; i < n; i++) {
                array[i] = row[i] == '0' ? 0 : array[i] + 1;
            }
            ans = Math.max(ans, largestRectangleArea(n));
        }
        return ans;
    }

    private int largestRectangleArea(int n) {
        int ans = 0, size = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && array[i] <= array[stack[size - 1]]) {
                int cur = stack[--size];
                int left = size > 0 ? stack[size - 1] : -1;
                ans = Math.max(ans, (i - left - 1) *  array[cur]);
            }
            stack[size++] = i;
        }
        while (size > 0) {
            int cur = stack[--size];
            int left = size > 0 ? stack[size - 1] : -1;
            ans = Math.max(ans, (n - left - 1) * array[cur]);
        }
        return ans;
    }
}
