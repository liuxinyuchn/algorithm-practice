package bit;

// lc 136.只出现一次的数字
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
