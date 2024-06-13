package tree.binary;

// lc 235.二叉搜索树的最近公共祖先
public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != p && root != q) {
            if (root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val, q.val)) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }
}
