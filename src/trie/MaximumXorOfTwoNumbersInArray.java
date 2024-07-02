package trie;

import java.util.Arrays;
import java.util.HashSet;

// lc 421.数组中两个数的最大异或值
public class MaximumXorOfTwoNumbersInArray {

    // hash 表解法
    public int findMaximumXOR1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 31 - Integer.numberOfLeadingZeros(max); i >= 0; i--) {
            int better = ans | (1 << i);
            set.clear();
            for (int num : nums) {
                num = (num >> i) << i;
                set.add(num);
                if (set.contains(num ^ better)) {
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }

    private static final int MAXN = 3000001;

    private static final int[][] tree = new int[MAXN][2];

    private static int cnt;

    private static int high;

    // 前缀树解法
    public int findMaximumXOR2(int[] nums) {
        int ans = 0;
        build(nums);
        for (int num : nums) {
            ans = Math.max(ans, maxXor(num));
        }
        return ans;
    }

    private void build(int[] nums) {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
        }
        cnt = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        high = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num);
        }
    }

    private void insert(int num) {
        int cur = 1;
        for (int i = high; i >= 0; i--) {
            int path = (num >> i) & 1;
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    private int maxXor(int num) {
        int cur = 1;
        int ans = 0;
        for (int i = high; i >= 0; i--) {
            int status = (num >> i) & 1;
            int want = status ^ 1;
            if (tree[cur][want] == 0) {
                want ^= 1;
            }
            ans |= (status ^ want) << i;
            cur = tree[cur][want];
        }
        return ans;
    }
}
