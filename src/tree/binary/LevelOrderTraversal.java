package tree.binary;

import java.util.ArrayList;
import java.util.List;

// lc 102.二叉树的层序遍历
public class LevelOrderTraversal {

    private static final TreeNode[] array = new TreeNode[2001];

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            int l = 0, r = 0;
            array[r++] = root;
            while (l < r) {
                int size = r - l;
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = array[l++];
                    list.add(node.val);
                    if (node.left != null) {
                        array[r++] = node.left;
                    }
                    if (node.right != null) {
                        array[r++] = node.right;
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}
