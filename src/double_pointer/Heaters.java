package double_pointer;

import java.util.Arrays;

// lc 475.供暖器
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0, i = 0, j = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
            }
            ans = Math.max(Math.abs(houses[i++] - heaters[j]), ans);
        }
        return ans;
    }
}
