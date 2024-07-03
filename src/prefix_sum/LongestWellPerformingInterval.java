package prefix_sum;

import java.util.HashMap;
import java.util.Map;

// lc 1124.表现良好的最长时间段
public class LongestWellPerformingInterval {

    public int longestWPI(int[] hours) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                ans = i + 1;
            } else {
                if (map.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
