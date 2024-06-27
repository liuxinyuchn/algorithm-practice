package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// lc 94.二叉树的中序遍历
public class InorderTraversal {

    // 验证
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println(recursiveInorderTraversal(head));
        System.out.println(nonRecursiveInorderTraversal(head));
    }

    // 递归中序遍历
    public static List<Integer> recursiveInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(recursiveInorderTraversal(root.left));
            result.add(root.val);
            result.addAll(recursiveInorderTraversal(root.right));
        }
        return result;
    }

    // 非递归中序遍历
    public static List<Integer> nonRecursiveInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
