package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 90.子集Ⅱ
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recursion(nums, 0, new int[nums.length], 0, result);
        return result;
    }

    private void recursion(int[] nums, int i, int[] path, int size, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            result.add(cur);
            return;
        }
        int j = i + 1;
        while (j < nums.length && nums[j] == nums[i]) {
            j++;
        }
        recursion(nums, j, path, size, result);
        while (i < j) {
            path[size++] = nums[i];
            recursion(nums, j, path, size, result);
            i++;
        }
    }
}
