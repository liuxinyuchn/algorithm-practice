package prefix_sum;

// lc 304.二维区域和检索 - 矩阵不可变
public class RangeSumQuery2dImmutable {

    static class NumMatrix {

        private static int[][] prefixSum;

        // 给定整数矩阵 matrix 进行初始化
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            prefixSum = new int[m + 1][n + 1];
            for (int a = 1, c = 0; c < m; a++, c++) {
                for (int b = 1, d = 0; d < n; b++, d++) {
                    prefixSum[a][b] = matrix[c][d];
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
                }
            }
        }

        // 返回左上角 (row1, col1)、右下角 (row2, col2) 所描述的子矩阵的元素总和
        public int sumRegion(int row1, int col1, int row2, int col2) {
            row2++;
            col2++;
            return prefixSum[row2][col2] - prefixSum[row1][col2] - prefixSum[row2][col1] + prefixSum[row1][col1];
        }
    }
}
