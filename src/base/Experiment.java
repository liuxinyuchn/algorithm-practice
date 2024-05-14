package base;

import java.util.Arrays;

// 一开始有 100 个人，每个人都有 100 元
// 在每一轮都做如下的事情 :
// 每个人都必须拿出 1 元钱给除自己以外的其他人，给谁完全随机
// 如果某个人在这一轮的钱数为 0，那么他可以不给，但是可以接收
// 发生很多很多轮之后，这 100 人的社会财富分布很均匀吗？
public class Experiment {

    public static void main(String[] args) {
        // n 个人，t 轮实验
        int n = 100;
        int t = 100000;
        experiment(n, t);
        System.out.println("实验结束");
    }

    public static void experiment(int n, int t) {
        double[] wealth = new double[n];
        Arrays.fill(wealth, 100);
        boolean[] hasMoney = new boolean[n];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                hasMoney[j] = wealth[j] > 0;
            }
            for (int j = 0; j < n; j++) {
                if (!hasMoney[j]) {
                    continue;
                }
                int other = j;
                while (other == j) {
                    other = (int) (Math.random() * n);
                }
                wealth[j]--;
                wealth[other]++;
            }
        }
        Arrays.sort(wealth);
        System.out.println("列出每个人的财富(贫穷到富有) : ");
        for (int i = 0; i < n; i++) {
            System.out.print((int) wealth[i] + " ");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("这个社会的基尼系数为 : " + calculateGini(wealth));
    }

    // 计算基尼系数
    public static double calculateGini(double[] wealth) {
        double sumOfAbsoluteDifferences = 0;
        double sumOfWealth = 0;
        int n = wealth.length;
        for (double value : wealth) {
            sumOfWealth += value;
            for (double otherValue : wealth) {
                sumOfAbsoluteDifferences += Math.abs(value - otherValue);
            }
        }
        return sumOfAbsoluteDifferences / (2 * n * sumOfWealth);
    }
}
