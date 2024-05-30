package bit;

// lc 268.丢失的数字
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xorAll = nums.length, xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xorAll ^= i;
        }
        return xorAll ^ xor;
    }
}
