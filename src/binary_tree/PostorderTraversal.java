package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// lc 145.二叉树的后序遍历
public class PostorderTraversal {

    // 验证
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println(recursivePostorderTraversal(head));
        System.out.println(nonRecursivePreorderTraversalByTwoStack(head));
        System.out.println(nonRecursivePreorderTraversalByOneStack(head));
    }

    // 递归后序遍历
    public static List<Integer> recursivePostorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(recursivePostorderTraversal(root.left));
            result.addAll(recursivePostorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }

    // 双栈非递归后序遍历
    public static List<Integer> nonRecursivePreorderTraversalByTwoStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> collect = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            collect.push(root);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!collect.empty()) {
            result.add(collect.pop().val);
        }
        return result;
    }

    // 单栈非递归后序遍历
    public static List<Integer> nonRecursivePreorderTraversalByOneStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null && cur.left != root && cur.right != root) {
                stack.push(cur.left);
            } else if (cur.right != null && cur.right != root) {
                stack.push(cur.right);
            } else {
                root = stack.pop();
                result.add(root.val);
            }
        }
        return result;
    }
}
