package monotonic_queue;

import java.util.Arrays;

// lc 2071.你可以安排的最多任务数量
public class MaxTaskAssign {

    private static final int MAX = 50001;

    private static final int[] queue = new int[MAX];

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int ans = 0, l = 0, r = Math.min(tasks.length, workers.length);
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (canFinish(tasks, workers, m, pills, strength)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private boolean canFinish(int[] tasks, int[] workers, int taskCount, int pills, int strength) {
        int pillCount = 0, head = 0, tail = 0;
        for (int i = 0, j = workers.length - taskCount; j < workers.length; j++) {
            while (i < taskCount && workers[j] >= tasks[i]) {
                queue[tail++] = i++;
            }
            if (head < tail && workers[j] >= tasks[queue[head]]) {
                head++;
            } else {
                while (i < taskCount && workers[j] + strength >= tasks[i]) {
                    queue[tail++] = i++;
                }
                if (head < tail) {
                    pillCount++;
                    tail--;
                } else {
                    return false;
                }
            }
        }
        return pillCount <= pills;
    }
}
