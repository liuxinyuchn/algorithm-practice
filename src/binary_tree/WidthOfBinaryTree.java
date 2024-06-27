package binary_tree;

// lc 662.二叉树最大宽度
public class WidthOfBinaryTree {

    private static final TreeNode[] nodeArray = new TreeNode[3000];

    private static final int[] indexArray = new int[3000];

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        int l = 0, r = 0;
        nodeArray[r] = root;
        indexArray[r++] = 1;
        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, indexArray[r - 1] - indexArray[l] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeArray[l];
                int index = indexArray[l++];
                if (node.left != null) {
                    nodeArray[r] = node.left;
                    indexArray[r++] = 2 * index;
                }
                if (node.right != null) {
                    nodeArray[r] = node.right;
                    indexArray[r++] = 2 * index + 1;
                }
            }
        }
        return ans;
    }
}
