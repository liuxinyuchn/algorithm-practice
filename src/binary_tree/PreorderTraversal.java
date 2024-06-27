package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// lc 144.二叉树的前序遍历
public class PreorderTraversal {

    // 验证
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println(recursivePreorderTraversal(head));
        System.out.println(nonRecursivePreorderTraversal(head));
    }

    // 递归前序遍历
    public static List<Integer> recursivePreorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(recursivePreorderTraversal(root.left));
            result.addAll(recursivePreorderTraversal(root.right));
        }
        return result;
    }

    // 非递归前序遍历
    public static List<Integer> nonRecursivePreorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }
}
