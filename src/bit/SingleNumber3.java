package bit;

// lc 260.只出现一次的数字Ⅲ
public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int right = xor & -xor;
        int first = 0;
        for (int num : nums) {
            if ((num & right) == 0) {
                first ^= num;
            }
        }
        return new int[]{first, xor ^ first};
    }
}
