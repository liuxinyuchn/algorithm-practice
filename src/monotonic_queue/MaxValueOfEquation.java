package monotonic_queue;

// lc 1499.满足不等式的最大值
public class MaxValueOfEquation {

    private static final int MAX = 100001;

    private static final int[] queue = new int[MAX];

    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE, head = 0, tail = 0;
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            while (head < tail && x - points[queue[head]][0] > k) {
                head++;
            }
            if (head < tail) {
                ans = Math.max(ans, x + y + points[queue[head]][1] - points[queue[head]][0]);
            }
            while (head < tail && y - x >= points[queue[tail - 1]][1] - points[queue[tail - 1]][0]) {
                tail--;
            }
            queue[tail++] = i;
        }
        return ans;
    }
}
