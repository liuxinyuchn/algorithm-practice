package bit;

// lc 137.只出现一次的数字Ⅱ
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans |= (count[i] % 3) << i;
        }
        return ans;
    }
}
