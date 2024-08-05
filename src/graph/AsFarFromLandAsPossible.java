package graph;

// lc 1162.地图分析
public class AsFarFromLandAsPossible {

    private static final int MAXN = 101;

    private static final int[][] queue = new int[MAXN * MAXN][2];

    private static int l, r;

    private static final boolean[][] visited = new boolean[MAXN][MAXN];

    private static final int[] move = new int[]{-1, 0, 1, 0, -1};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        l = r = 0;
        int seaCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                } else {
                    visited[i][j] = false;
                    seaCount++;
                }
            }
        }
        if (seaCount == 0 || seaCount == n * n) {
            return -1;
        }
        int level = 0;
        while (l < r) {
            level++;
            int size = r - l;
            for (int k = 0; k < size; k++) {
                int x = queue[l][0], y = queue[l++][1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + move[i], ny = y + move[i + 1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                    }
                }
            }
        }
        return level - 1;
    }
}
