package binary_tree;

// lc 337.打家劫舍 Ⅲ
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] income = dfs(root);
        return Math.max(income[0], income[1]);
    }

    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);
        int robIncome = left[0] + right[0] + cur.val;
        int notRobIncome = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{notRobIncome, robIncome};
    }
}
