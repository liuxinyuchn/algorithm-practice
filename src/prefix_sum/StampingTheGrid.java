package prefix_sum;

// lc 2132.用邮票贴满网格图
public class StampingTheGrid {

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int[][] sumGrid = getSumGrid(grid);
        // 遍历能贴邮票的位置，并记录
        int[][] recordGrid = new int[grid.length + 2][grid[0].length + 2];
        for (int a = 1, c = a + stampHeight - 1; c <= grid.length; a++, c++) {
            for (int b = 1, d = b + stampWidth - 1; d <= grid[0].length; b++, d++) {
                if (getRegionSum(sumGrid, a, b, c, d) == 0) {
                    record(recordGrid, a, b, c, d);
                }
            }
        }
        build(recordGrid);
        // 对比贴邮票前后记录，判断是否全部贴满
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && recordGrid[i + 1][j + 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // 获取区域和网格
    private int[][] getSumGrid(int[][] grid) {
        int[][] sumGrid = new int[grid.length + 1][grid[0].length + 1];
        for (int a = 0, c = 1; a < grid.length; a++, c++){
            for (int b = 0, d = 1; b < grid[0].length; b++, d++) {
                sumGrid[c][d] = grid[a][b];
            }
        }
        build(sumGrid);
        return sumGrid;
    }

    // 计算前缀和
    private void build(int[][] g) {
        for (int i = 1; i < g.length; i++) {
            for (int j = 1; j < g[0].length; j++) {
                g[i][j] += g[i - 1][j] + g[i][j - 1] - g[i - 1][j - 1];
            }
        }
    }

    // 获取区域和
    private int getRegionSum(int[][] sumGrid, int a, int b, int c, int d) {
        return sumGrid[c][d] - sumGrid[a - 1][d] - sumGrid[c][b - 1] + sumGrid[a - 1][b - 1];
    }

    // 记录邮票粘贴
    private void record(int[][] recordGrid, int a, int b, int c, int d) {
        recordGrid[a][b]++;
        recordGrid[a][d + 1]--;
        recordGrid[c + 1][b]--;
        recordGrid[c + 1][d + 1]++;
    }
}
