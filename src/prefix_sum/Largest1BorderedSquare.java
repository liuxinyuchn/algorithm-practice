package prefix_sum;

// lc 1139.最大的以 1 为边界的正方形
public class Largest1BorderedSquare {

    public int largest1BorderedSquare(int[][] grid) {
        build(grid);
        int m = grid.length;
        int n = grid[0].length;
        if (grid[m - 1][n - 1] == 0) {
            return 0;
        }
        int side = 1;
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = a + side, d = b + side, k = side + 1; c < m && d < n; c++, d++, k++) {
                    if (sum(grid, a, b, c, d) - sum(grid, a + 1, b + 1, c - 1, d - 1) == (k - 1) << 2) {
                        side = k;
                    }
                }
            }
        }
        return side * side;
    }

    private void build(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += getElement(grid, i - 1, j) + getElement(grid, i, j - 1) - getElement(grid, i - 1, j - 1);
            }
        }
    }

    private int sum(int[][] grid, int a, int b, int c, int d) {
        return c < a ? 0 : grid[c][d] - getElement(grid, a - 1, d) - getElement(grid, c, b - 1) + getElement(grid, a - 1, b - 1);
    }

    private int getElement(int[][] grid, int i, int j) {
        return i < 0 || j < 0 ? 0 : grid[i][j];
    }
}
