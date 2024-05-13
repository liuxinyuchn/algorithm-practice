package introductory;

// 二进制
public class Binary {

    public static void main(String[] args) {
        int nonnegativeNum = 78;
        int negativeNum = -78;
        // 非负整数的二进制表达
        System.out.println("非负整数的二进制表达:");
        printBinary(nonnegativeNum);
        // 负整数的二进制表达
        System.out.println("负整数的二进制表达:");
        printBinary(negativeNum);
        // 直接定义二进制
        int binaryNum = 0b11111111111111111111111110110010;
        System.out.println("直接定义二进制:");
        System.out.println(binaryNum);
        // 直接定义十六进制
        int hexadecimalNum = 0xffffffb2;
        System.out.println("直接定义十六进制:");
        System.out.println(hexadecimalNum);
        // 位运算
        System.out.println("位运算:");
        int a = 0b00000000000000000000000000001100;
        int b = 0b00000000000000000000000000001011;
        printBinary(a);
        printBinary(b);
        // 位运算：&
        System.out.println("位运算 [&]:");
        printBinary(a & b);
        // 位运算：|
        System.out.println("位运算 [|]:");
        printBinary(a | b);
        // 位运算：^
        System.out.println("位运算 [^]:");
        printBinary(a ^ b);
        // 位运算：~
        System.out.println("位运算 [~]:");
        printBinary(a);
        printBinary(~a);
        // 位运算：<<
        System.out.println("位运算 [<<]:");
        printBinary(nonnegativeNum);
        printBinary(nonnegativeNum << 1);
        printBinary(nonnegativeNum << 2);
        printBinary(nonnegativeNum << 3);
        // 位运算：非负整数 >>
        System.out.println("位运算 [非负整数 >>]:");
        printBinary(nonnegativeNum);
        printBinary(nonnegativeNum >> 1);
        printBinary(nonnegativeNum >> 2);
        printBinary(nonnegativeNum >> 3);
        // 位运算：非负整数 >>>
        System.out.println("位运算 [非负整数 >>>]:");
        printBinary(nonnegativeNum);
        printBinary(nonnegativeNum >>> 1);
        printBinary(nonnegativeNum >>> 2);
        printBinary(nonnegativeNum >>> 3);
        // 位运算：负整数 >>
        System.out.println("位运算 [负整数 >>]:");
        printBinary(negativeNum);
        printBinary(negativeNum >> 1);
        printBinary(negativeNum >> 2);
        printBinary(negativeNum >> 3);
        // 位运算：负整数 >>>
        System.out.println("位运算 [负整数 >>>]:");
        printBinary(negativeNum);
        printBinary(negativeNum >>> 1);
        printBinary(negativeNum >>> 2);
        printBinary(negativeNum >>> 3);
    }

    /**
     * print binary
     *
     * @param num num
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
