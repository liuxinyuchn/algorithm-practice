package double_pointer;

import java.util.Arrays;

// lc 881.救生艇
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            int sum = l == r ? people[l] : people[l] + people[r];
            if (sum <= limit) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }
}
