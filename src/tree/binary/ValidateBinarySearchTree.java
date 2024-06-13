package tree.binary;

// lc 98.验证二叉搜索树
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode cur, long min, long max) {
        if (cur == null) {
            return true;
        }
        if (cur.val <= min || cur.val >= max) {
            return false;
        }
        return check(cur.left, min, cur.val)
                && check(cur.right, cur.val, max);
    }
}
