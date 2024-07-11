package binary_search;

// lc 2141.同时运行 N 台电脑的最长时间
public class MaxRunningTimeOfNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        int max = 0;
        for (int battery : batteries) {
            sum += battery;
            max = Math.max(max, battery);
        }
        if (sum >= (long) max * n) {
            return sum / n;
        }
        int ans = 0, l = 0, r = max;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (canRun(n, batteries, m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private boolean canRun(int n, int[] batteries, int expectedTime) {
        long sum = 0;
        for (int battery : batteries) {
            if (battery > expectedTime) {
                n--;
            } else {
                sum += battery;
            }
            if (sum >= (long) expectedTime * n) {
                return true;
            }
        }
        return false;
    }
}
