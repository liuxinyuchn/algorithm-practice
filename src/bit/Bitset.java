package bit;

// lc 2166.设计位集
public class Bitset {

    private static final int BIT_SIZE = 32;

    private final int[] set;

    private final int size;

    private int zeroCount;

    private int oneCount;

    private boolean reverse;

    // 用 size 个位初始化 Bitset，所有位都是 0
    public Bitset(int size) {
        this.set = new int[(size + BIT_SIZE - 1) / BIT_SIZE];
        this.size = size;
        this.zeroCount = size;
        this.oneCount = 0;
        this.reverse = false;
    }

    // 将下标为 idx 的位上的值更新为 1。如果值已经是 1，则不会发生任何改变
    public void fix(int idx) {
        int i = idx / BIT_SIZE;
        int bit = idx % BIT_SIZE;
        if (!reverse && (set[i] & (1 << bit)) == 0) {
            set[i] |= (1 << bit);
            zeroCount--;
            oneCount++;
        }
        if (reverse && (set[i] & (1 << bit)) != 0) {
            set[i] ^= (1 << bit);
            zeroCount--;
            oneCount++;
        }
    }

    // 将下标为 idx 的位上的值更新为 0。如果值已经是 0，则不会发生任何改变
    public void unfix(int idx) {
        int i = idx / BIT_SIZE;
        int bit = idx % BIT_SIZE;
        if (!reverse && (set[i] & (1 << bit)) != 0) {
            set[i] ^= (1 << bit);
            zeroCount++;
            oneCount--;
        }
        if (reverse && (set[i] & (1 << bit)) == 0) {
            set[i] |= (1 << bit);
            zeroCount++;
            oneCount--;
        }
    }

    // 翻转 Bitset 中每一位上的值。换句话说，所有值为 0 的位将会变成 1，反之亦然
    public void flip() {
        reverse = !reverse;
        zeroCount ^= oneCount;
        oneCount ^= zeroCount;
        zeroCount ^= oneCount;
    }

    // 检查 Bitset 中每一位的值是否都是 1。如果满足此条件，返回 true；否则，返回 false
    public boolean all() {
        return oneCount == size;
    }

    // 检查 Bitset 中是否至少一位的值是 1。如果满足此条件，返回 true；否则，返回 false
    public boolean one() {
        return oneCount > 0;
    }

    // 返回 Bitset 中值为 1 的位的总数
    public int count() {
        return oneCount;
    }

    // 返回 Bitset 的当前组成情况。注意，在结果字符串中，第 i 个下标处的字符应该与 Bitset 中的第 i 位一致
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, cur = 0; cur < size; i++) {
            int num = set[i];
            for (int bit = 0; cur < size && bit < BIT_SIZE; cur++, bit++) {
                int status = (num >> bit) & 1;
                status ^= reverse ? 1 : 0;
                builder.append(status);
            }
        }
        return builder.toString();
    }
}
