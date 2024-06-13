package tree.binary;

// lc 110.平衡二叉树
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int leftHeight = getHeight(cur.left);
        int rightHeight = getHeight(cur.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
