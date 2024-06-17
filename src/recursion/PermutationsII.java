package recursion;

import java.util.ArrayList;
import java.util.List;

// lc 47.全排列Ⅱ
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        int[] usedHash = new int[21];
        for (int j = i; j < nums.length; j++) {
            if (usedHash[nums[j] + 10] == 1) {
                continue;
            }
            usedHash[nums[j] + 10] = 1;
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
