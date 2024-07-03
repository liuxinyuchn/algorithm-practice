package prefix_sum;

import java.util.HashMap;
import java.util.Map;

// lc 1590.使数组和能被 P 整除
public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        int ans = Integer.MAX_VALUE, mod = 0;
        for (int num : nums) {
            mod = (mod + num) % p;
        }
        if (mod == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, cur = 0, find; i < nums.length; i++) {
            cur = (cur + nums[i]) % p;
            find = (cur - mod + p) % p;
            if (map.containsKey(find)) {
                ans = Math.min(ans, i - map.get(find));
            }
            map.put(cur, i);
        }
        return ans < nums.length ? ans : -1;
    }
}
