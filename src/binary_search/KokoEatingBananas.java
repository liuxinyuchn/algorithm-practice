package binary_search;

// lc 875.爱吃香蕉的珂珂
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int ans = 1, l = 1, r = max;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            long requireTime = getRequiredTime(piles, m);
            if (requireTime <= h) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private long getRequiredTime(int[] piles, int speed) {
        long ans = 0;
        for (int pile : piles) {
            ans += (pile - 1) / speed + 1;
        }
        return ans;
    }
}
