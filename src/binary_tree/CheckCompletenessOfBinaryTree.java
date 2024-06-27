package binary_tree;

// lc 958.二叉树的完全性校验
public class CheckCompletenessOfBinaryTree {

    private static final TreeNode[] array = new TreeNode[100];

    public boolean isCompleteTree(TreeNode root) {
        int l = 0, r = 0;
        array[r++] = root;
        boolean flag = false;
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                TreeNode node = array[l++];
                if ((node.left == null && node.right != null) || (flag && (node.left != null || node.right != null))) {
                    return false;
                }
                if (node.left != null) {
                    array[r++] = node.left;
                }
                if (node.right != null) {
                    array[r++] = node.right;
                }
                if (node.left == null || node.right == null) {
                    flag = true;
                }
            }
        }
        return true;
    }
}
