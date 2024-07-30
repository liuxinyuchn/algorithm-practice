package graph;

// lc 851.喧闹与富有
public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length, m = richer.length + 1, cnt = 1, l = 0, r = 0;
        int[] head = new int[n], next = new int[m], to = new int[m], indegree = new int[n], queue = new int[n];
        for (int[] edge : richer) {
            next[cnt] = head[edge[0]];
            to[cnt] = edge[1];
            head[edge[0]] = cnt++;
            indegree[edge[1]]++; 
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
            ans[i] = i;
        }
        while (l < r) {
            int cur = queue[l++];
            for (int e = head[cur]; e > 0; e = next[e]) {
                int nextNode = to[e];
                if (quiet[ans[cur]] < quiet[ans[nextNode]]) {
                    ans[nextNode] = ans[cur];
                }
                if (--indegree[nextNode] == 0) {
                    queue[r++] = nextNode;
                }
            }
        }
        return ans;
    }
}
