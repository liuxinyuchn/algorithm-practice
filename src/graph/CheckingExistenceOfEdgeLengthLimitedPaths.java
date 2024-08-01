package graph;

import java.util.Arrays;

// lc 1697.检查边长度限制的路径是否存在
public class CheckingExistenceOfEdgeLengthLimitedPaths {

    private static final int MAX_SIZE = 100001;

    private static final int[] father = new int[MAX_SIZE];

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        build(n);
        int qLen = queries.length, eLen = edgeList.length;
        int[][] questions = new int[qLen][4];
        for (int i = 0; i < qLen; i++) {
            questions[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(questions, (a, b) -> a[2] - b[2]);
        boolean[] ans = new boolean[qLen];
        for (int i = 0, j = 0; i < qLen; i++) {
            while (j < eLen && edgeList[j][2] < questions[i][2]) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            ans[questions[i][3]] = find(questions[i][0]) == find(questions[i][1]);
        }
        return ans;
    }

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    private int find(int i) {
        if (father[i] != i) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
        }
    }
}
