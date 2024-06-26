package math;

// lc 906.超级回文数
public class SuperPalindromes {

    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        long limit = (long) Math.sqrt((double) r);
        long seed = 1L, oddExpansion = 0L, evenExpansion = 0L;
        int ans = 0;
        while (oddExpansion <= limit) {
            oddExpansion = getOddExpansion(seed);
            if (check(oddExpansion * oddExpansion, l, r)) {
                ans++;
            }
            evenExpansion = getEvenExpansion(seed);
            if (check(evenExpansion * evenExpansion, l, r)) {
                ans++;
            }
            seed++;
        }
        return ans;
    }

    private long getOddExpansion(long x) {
        long result = x;
        x /= 10;
        while (x > 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    private long getEvenExpansion(long x) {
        long result = x;
        while (x > 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    private boolean check(long x, long l, long r) {
        return x >= l && x <= r && isPalindromeNumber(x);
    }

    private boolean isPalindromeNumber(long x) {
        long offset = 1L;
        while (x / offset >= 10) {
            offset *= 10;
        }
        while (x > 0) {
            if (x / offset != (x % 10)) {
                return false;
            }
            x = (x % offset) / 10;
            offset /= 100;
        }
        return true;
    }
}
