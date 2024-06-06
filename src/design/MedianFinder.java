package design;

import java.util.PriorityQueue;

// lc 295.数据流的中位数
public class MedianFinder {

    private final PriorityQueue<Integer> left;

    private final PriorityQueue<Integer> right;

    // 初始化 MedianFinder 对象
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    // 将数据流中的整数 num 添加到数据结构中
    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        if (Math.abs(left.size() - right.size()) == 2) {
            if (left.size() > right.size()) {
                right.offer(left.poll());
            } else {
                left.offer(right.poll());
            }
        }
    }

    // 返回到目前为止所有元素的中位数
    public double findMedian() {
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        }
        return left.size() > right.size() ? left.peek() : right.peek();
    }
}
