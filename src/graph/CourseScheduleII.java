package graph;

// lc 210.课程表 Ⅱ
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int size = 1, edgeCount = prerequisites.length + 1;
        int[] head = new int[numCourses + 1];
        int[] next = new int[edgeCount];
        int[] to = new int[edgeCount];
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            next[size] = head[edge[1]];
            to[size] = edge[0];
            head[edge[1]] = size++;
            indegree[edge[0]]++;
        }
        int[] queue = new int[numCourses];
        int l = 0, r = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int cnt = 0;
        while (l < r) {
            int cur = queue[l++];
            cnt++;
            for (int e = head[cur]; e > 0; e = next[e]) {
                if (--indegree[to[e]] == 0) {
                    queue[r++] = to[e];
                }
            }
        }
        return cnt == numCourses ? queue : new int[0];
    }
}
