package tree.binary;

import java.util.ArrayList;
import java.util.List;

// lc 103.二叉树的锯齿形层序遍历
public class ZigzagLevelOrderTraversal {

    private static final TreeNode[] array = new TreeNode[2000];

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            int l = 0, r = 0;
            boolean reverse = false;
            array[r++] = root;
            while (l < r) {
                int size = r - l;
                List<Integer> list = new ArrayList<>();
                for (int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0; k < size; i += j, k++) {
                    list.add(array[i].val);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode node = array[l++];
                    if (node.left != null) {
                        array[r++] = node.left;
                    }
                    if (node.right != null) {
                        array[r++] = node.right;
                    }
                }
                result.add(list);
                reverse = !reverse;
            }
        }
        return result;
    }
}
