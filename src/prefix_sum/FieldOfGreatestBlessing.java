package prefix_sum;

import java.util.Arrays;

// LCP 74.最强祝福力场
public class FieldOfGreatestBlessing {

    public int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        long[] xs = new long[n << 1];
        long[] ys = new long[n << 1];
        for (int i = 0, j = 0, k = 0; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];
            xs[j++] = (x << 1) - r;
            xs[j++] = (x << 1) + r;
            ys[k++] = (y << 1) - r;
            ys[k++] = (y << 1) + r;
        }
        int xSize = sort(xs);
        int ySize = sort(ys);
        int[][] diff = new int[xSize + 2][ySize + 2];
        for (int[] field : forceField) {
            long x = field[0];
            long y = field[1];
            long r = field[2];
            int a = rank(xs, (x << 1) - r, xSize);
            int b = rank(ys, (y << 1) - r, ySize);
            int c = rank(xs, (x << 1) + r, xSize);
            int d = rank(ys, (y << 1) + r, ySize);
            diff[a][b]++;
            diff[a][d + 1]--;
            diff[c + 1][b]--;
            diff[c + 1][d + 1]++;
        }
        int ans = 0;
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[0].length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                ans = Math.max(ans, diff[i][j]);
            }
        }
        return ans;
    }

    private int sort(long[] nums) {
        Arrays.sort(nums);
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[size - 1]) {
                nums[size++] = nums[i];
            }
        }
        return size;
    }

    private int rank(long[] nums, long target, int size) {
        int l = 0, r = size - 1, ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans + 1;
    }
}
