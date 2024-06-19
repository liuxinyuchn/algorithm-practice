package recursion;

// lc 52.N 皇后Ⅱ
public class NQueensII {

    public int totalNQueens(int n) {
        int count1 = count1(0, new int[n]);
        int count2 = count2((1 << n) - 1, 0, 0, 0);
        return count1;
    }

    // 数组方式实现
    private int count1(int i, int[] limit) {
        if (i == limit.length) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < limit.length; j++) {
            if (check(limit, i, j)) {
                limit[i] = j;
                ans += count1(i + 1, limit);
            }
        }
        return ans;
    }

    private boolean check(int[] limit, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (limit[k] == j || Math.abs(i - k) == Math.abs(j - limit[k])) {
                return false;
            }
        }
        return true;
    }

    // 位运算方式实现
    public int count2(int flag, int col, int left, int right) {
        if (col == flag) {
            return 1;
        }
        int limit = col | left | right;
        int candidate = flag & (~limit);
        int ans = 0;
        while (candidate > 0) {
            int place = candidate & (-candidate);
            candidate ^= place;
            ans += count2(flag, col | place, (left | place) << 1, (right | place) >> 1);
        }
        return ans;
    }
}
