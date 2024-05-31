package bit;

// lc 461.汉明距离
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        n = ((n & 0xaaaaaaaa) >>> 1) + (n & 0x55555555);
        n = ((n & 0xcccccccc) >>> 2) + (n & 0x33333333);
        n = ((n & 0xf0f0f0f0) >>> 4) + (n & 0x0f0f0f0f);
        n = ((n & 0xff00ff00) >>> 8) + (n & 0x00ff00ff);
        return ((n & 0xffff0000) >>> 16) + (n & 0x0000ffff);
    }
}
