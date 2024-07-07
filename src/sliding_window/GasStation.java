package sliding_window;

// lc 134.加油站
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int l = 0, r = 0, len = 0, surplus = 0; l < n; l++) {
            while (surplus >= 0) {
                if (len == n) {
                    return l;
                }
                r = (l + len++) % n;
                surplus += gas[r] - cost[r];
            }
            surplus -= gas[l] - cost[l];
            len--;
        }
        return -1;
    }
}
