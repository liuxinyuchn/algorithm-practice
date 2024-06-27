package binary_search;

// lc 878.第 N 个神奇数字
public class NthMagicalNumber {

    public int nthMagicalNumber(int n, int a, int b) {
        long ans = 0, lcm = lcm(a, b);
        for (long l = 0, r = (long) n * Math.min(a, b); l <= r;) {
            long m = (l + r) >> 1;
            if (m / a + m / b - m / lcm >= n) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    // 最大公约数
    private long gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 最小公倍数
    private long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }
}
