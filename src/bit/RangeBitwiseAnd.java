package bit;

// lc 201.数字范围按位与
public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right &= right - 1;
        }
        return right;
    }
}
