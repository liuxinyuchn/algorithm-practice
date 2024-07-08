package sliding_window;

// lc 1234.替换子串得到平衡字符串
public class ReplaceSubstringForBalancedString {

    public int balancedString(String s) {
        int n = s.length();
        int[] array = new int[n];
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            array[i] = s.charAt(i) == 'Q' ? 0 : (s.charAt(i) == 'W' ? 1 : s.charAt(i) == 'E' ? 2 : 3);
            cnt[array[i]]++;
        }
        int ans = Integer.MAX_VALUE, require = n / 4;
        for (int l = 0, r = 0; l < n; l++) {
            while (!canBalanced(cnt, require) && r < n) {
                cnt[array[r++]]--;
            }
            if (canBalanced(cnt, require)) {
                ans = Math.min(ans, r - l);
            }
            cnt[array[l]]++;
        }
        return ans;
    }

    private boolean canBalanced(int[] cnt, int require) {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] > require) {
                return false;
            }
        }
        return true;
    }
}
