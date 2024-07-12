package monotonic_stack;

// lc 739.每日温度
public class DailyTemperatures {

    private static final int MAX = 100001;

    private static final int[] array = new int[MAX];

    public int[] dailyTemperatures(int[] temperatures) {
        int size = 0, n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (size > 0 && temperatures[array[size - 1]] < temperatures[i]) {
                int left = array[--size];
                ans[left] = i - left;
            }
            array[size++] = i;
        }
        return ans;
    }
}
