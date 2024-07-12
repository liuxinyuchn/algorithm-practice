package monotonic_stack;

// lc 907.子数组的最小值之和
public class SumOfSubarrayMinimums {

    private static final int MOD = 1000000007;

    private static final int MAX = 30001;

    private static final int[] array = new int[MAX];

    public int sumSubarrayMins(int[] arr) {
        int size = 0, n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && arr[i] <= arr[array[size - 1]]) {
                int cur = array[--size];
                int left = size > 0 ? array[size - 1] : -1;
                sum = (sum + (long) arr[cur] * (cur - left) * (i - cur)) % MOD;
            }
            array[size++] = i;
        }
        while (size > 0) {
            int cur = array[--size];
            int left = size > 0 ? array[size - 1] : -1;
            sum = (sum + (long) arr[cur] * (cur - left) * (n - cur)) % MOD;
        }
        return (int) sum;
    }
}
