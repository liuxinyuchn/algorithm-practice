package trie;

import java.util.HashMap;
import java.util.Map;

// lc 560.和为 K 的子数组
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
