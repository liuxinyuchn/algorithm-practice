package bit;

// 整数位运算实现加减乘除
public class BitOperation {

    // 两数相加
    public int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    // 相反数
    public int neg(int a) {
        return add(~a, 1);
    }

    // 两数相减
    public int minus(int a, int b) {
        return add(a, neg(b));
    }

    // 两数相乘
    public int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    // a, b 非整数最小值相除
    public int div(int a, int b) {
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

    // lc 29.两数相除
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (dividend != Integer.MIN_VALUE && divisor != Integer.MIN_VALUE) {
            return div(dividend, divisor);
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (divisor == neg(1)) {
            return Integer.MAX_VALUE;
        }
        dividend = add(dividend, divisor > 0 ? divisor : neg(divisor));
        int ans = div(dividend, divisor);
        int offset = divisor > 0 ? neg(1) : 1;
        return add(ans, offset);
    }
}
