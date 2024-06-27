package binary_tree;

import java.util.HashMap;
import java.util.Map;

// lc 105.从前序与中序遍历序列构造二叉树
public class PreorderInorderBuildBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = inorder.length;
        Map<Integer, Integer> map = new HashMap<>(size * 4 / 3 + 1);
        for (int i = 0; i < size; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, size - 1, inorder, 0, size - 1, map);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return node;
        }
        int index = map.get(preorder[preStart]);
        node.left = build(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1, map);
        node.right = build(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd, map);
        return node;
    }
}
