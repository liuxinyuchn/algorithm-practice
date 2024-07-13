package monotonic_stack;

import java.util.Arrays;

// lc 1504.统计全 1 子矩形
public class CountSubmatricesWithAllOnes {

    private static final int MAX = 151;

    private static final int[] array = new int[MAX];

    private static final int[] stack = new int[MAX];

    public int numSubmat(int[][] mat) {
        int ans = 0, m = mat.length, n = mat[0].length;
        Arrays.fill(array, 0);
        for (int[] row : mat) {
            for (int i = 0; i < n; i++) {
                array[i] = row[i] == 0 ? 0 : array[i] + 1;
            }
            ans += countFromBottom(n);
        }
        return ans;
    }

    private int countFromBottom(int n) {
        int ans = 0, size = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && array[i] <= array[stack[size - 1]]) {
                int cur = stack[--size];
                if (array[i] < array[cur]) {
                    int left = size > 0 ? stack[size - 1] : -1;
                    int width = i - left - 1;
                    int height = array[cur] - Math.max(left == -1 ? 0 : array[left], array[i]);
                    ans += height * width * (width + 1) / 2;
                }
            }
            stack[size++] = i;
        }
        while (size > 0) {
            int cur = stack[--size];
            int left = size > 0 ? stack[size - 1] : -1;
            int width = n - left - 1;
            int height = array[cur] - (left == -1 ? 0 : array[left]);
            ans += height * width * (width + 1) / 2;
        }
        return ans;
    }
}
