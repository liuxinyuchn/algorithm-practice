package graph;

import java.util.PriorityQueue;

// lc 407.接雨水 II
public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        int[] move = {-1, 0, 1, 0, -1};
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    heap.add(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        while (!heap.isEmpty()) {
            int[] record = heap.poll();
            int x = record[0], y = record[1], h = record[2];
            ans += h - heightMap[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + move[i], ny = y + move[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    heap.add(new int[]{nx, ny, Math.max(h, heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }
        return ans;
    }
}
