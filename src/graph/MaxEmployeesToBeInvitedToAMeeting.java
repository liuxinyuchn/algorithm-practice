package graph;

// lc 2127.参加会议的最多员工数
public class MaxEmployeesToBeInvitedToAMeeting {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int[] deep = new int[n];
        while (l < r) {
            int cur = queue[l++], next = favorite[cur];
            deep[next] = Math.max(deep[next], deep[cur] + 1);
            if (--indegree[next] == 0) {
                queue[r++] = next;
            }
        }
        int sumOfSmallRing = 0;
        int bigRingSize = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                continue;
            }
            int ringSize = 1;
            indegree[i] = 0;
            for (int j = favorite[i]; j != i; j = favorite[j]) {
                ringSize++;
                indegree[j] = 0;
            }
            if (ringSize == 2) {
                sumOfSmallRing += 2 + deep[i] + deep[favorite[i]];
            } else {
                bigRingSize = Math.max(bigRingSize, ringSize);
            }
        }
        return Math.max(sumOfSmallRing, bigRingSize);
    }
}
