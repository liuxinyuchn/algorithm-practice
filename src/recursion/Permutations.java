package recursion;

import java.util.ArrayList;
import java.util.List;

// lc 46.全排列
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, 0, result);
        return result;
    }

    private void recursion(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            result.add(cur);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            recursion(nums, i + 1, result);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
