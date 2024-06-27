package binary_tree;

import java.util.ArrayList;
import java.util.List;

// lc 113.路径总和 Ⅱ
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            backTracking(root, targetSum, result, path);
        }
        return result;
    }

    private void backTracking(TreeNode cur, int target, List<List<Integer>> result, List<Integer> path) {
        if (cur.left == null && cur.right == null) {
            if (target == cur.val) {
                path.add(cur.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else {
            path.add(cur.val);
            if (cur.left != null) {
                backTracking(cur.left, target - cur.val, result, path);
            }
            if (cur.right != null) {
                backTracking(cur.right, target - cur.val, result, path);
            }
            path.remove(path.size() - 1);
        }
    }
}
