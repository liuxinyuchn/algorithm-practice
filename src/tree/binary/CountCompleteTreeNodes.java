package tree.binary;

// lc 222.完全二叉树的节点个数
public class CountCompleteTreeNodes {

    private static int height;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        height = countLeftLayers(root, 1);
        return countNodes(root, 1);
    }

    private int countNodes(TreeNode cur, int layer) {
        if (layer == height) {
            return 1;
        }
        if (countLeftLayers(cur.right, layer + 1) == height) {
            return (1 << (height - layer)) + countNodes(cur.right, layer + 1);
        }
        return (1 << (height - layer - 1)) + countNodes(cur.left, layer + 1);
    }

    private int countLeftLayers(TreeNode cur, int layer) {
        while (cur != null) {
            cur = cur.left;
            layer++;
        }
        return layer - 1;
    }
}
