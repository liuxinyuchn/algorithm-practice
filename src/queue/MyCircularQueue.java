package queue;

// lc 622. 设计循环队列
public class MyCircularQueue {

    private final int[] array;

    private final int length;

    private int headIndex;

    private int tailIndex;

    private int size;

    // 构造器，设置队列长度为 k
    public MyCircularQueue(int k) {
        array = new int[k];
        length = k;
        headIndex = 0;
        tailIndex = k - 1;
        size = 0;
    }

    // 向循环队列插入一个元素。如果成功插入则返回真
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tailIndex = tailIndex == length - 1 ? 0 : tailIndex + 1;
        array[tailIndex] = value;
        size++;
        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        headIndex = headIndex == length - 1 ? 0 : headIndex + 1;
        size--;
        return true;
    }

    // 从队首获取元素。如果队列为空，返回 -1
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[headIndex];
    }

    // 获取队尾元素。如果队列为空，返回 -1
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[tailIndex];
    }

    // 检查循环队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 检查循环队列是否已满
    public boolean isFull() {
        return size == length;
    }
}
