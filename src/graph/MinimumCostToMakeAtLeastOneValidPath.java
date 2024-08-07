package graph;

import java.util.ArrayDeque;
import java.util.Deque;

// lc 1368.使网格图至少有一条有效路径的最小代价
public class MinimumCostToMakeAtLeastOneValidPath {
    
    public int minCost(int[][] grid) {
        int[][] move = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[] { 0, 0 });
        distance[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] record = deque.pollFirst();
            int x = record[0], y = record[1];
            if (x == m - 1 && y == n - 1) {
                return distance[x][y];
            }
            for (int i = 1; i <= 4; i++) {
                int nx = x + move[i][0], ny = y + move[i][1];
                int w = grid[x][y] == i ? 0 : 1;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && distance[x][y] + w < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + w;
                    if (w == 0) {
                        deque.addFirst(new int[] {nx, ny});
                    } else {
                        deque.addLast(new int[] {nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
