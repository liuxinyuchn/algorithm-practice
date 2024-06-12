package tree.binary;

// lc 111.二叉树的最小深度
public class MinDepth {

    private static final TreeNode[] array = new TreeNode[100000];

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 0, r = 0, depth = 0;
        array[r++] = root;
        while (l < r) {
            int size = r - l;
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = array[l++];
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    array[r++] = node.left;
                }
                if (node.right != null) {
                    array[r++] = node.right;
                }
            }
        }
        return depth;
    }
}
