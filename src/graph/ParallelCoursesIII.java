package graph;

// lc 2050.并行课程 Ⅲ
public class ParallelCoursesIII {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int m = relations.length + 1;
        int[] head = new int[n + 1], next = new int[m], to = new int[m], indegree = new int[n + 1];
        int cnt = 1;
        for (int[] relation : relations) {
            next[cnt] = head[relation[0]];
            to[cnt] = relation[1];
            head[relation[0]] = cnt++;
            indegree[relation[1]]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int ans = 0;
        int[] cost = new int[n + 1];
        while (l < r) {
            int cur = queue[l++];
            cost[cur] += time[cur - 1];
            ans = Math.max(ans, cost[cur]);
            for (int e = head[cur]; e > 0; e = next[e]) {
                int nextNode = to[e];
                cost[nextNode] = Math.max(cost[nextNode], cost[cur]);
                if (--indegree[nextNode] == 0) {
                    queue[r++] = nextNode;
                }
            }
        }
        return ans;
    }
}
