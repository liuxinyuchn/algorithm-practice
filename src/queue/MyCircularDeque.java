package queue;

// lc 641.设计循环双端队列
public class MyCircularDeque {

    private final int[] array;

    private final int limit;

    private int head;

    private int tail;

    private int size;

    // 构造函数,双端队列最大为 k
    public MyCircularDeque(int k) {
        array = new int[k];
        limit = k;
        head = 0;
        tail = 0;
        size = 0;
    }

    // 将一个元素添加到双端队列头部。
    // 如果操作成功返回 true ，否则返回 false
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            head = getLeftIndex(head);
        }
        array[head] = value;
        size++;
        return true;
    }

    // 将一个元素添加到双端队列尾部。
    // 如果操作成功返回 true ，否则返回 false
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            tail = getRightIndex(tail);
        }
        array[tail] = value;
        size++;
        return true;
    }

    // 从双端队列头部删除一个元素。
    // 如果操作成功返回 true ，否则返回 false
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = getRightIndex(head);
        size--;
        return true;
    }

    // 从双端队列尾部删除一个元素。
    // 如果操作成功返回 true ，否则返回 false
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = getLeftIndex(tail);
        size--;
        return true;
    }

    // 从双端队列头部获得一个元素。
    // 如果双端队列为空，返回 -1
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[head];
    }

    // 获得双端队列的最后一个元素。
    // 如果双端队列为空，返回 -1
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[tail];
    }

    // 若双端队列为空，则返回 true ，否则返回 false
    public boolean isEmpty() {
        return size == 0;
    }

    // 若双端队列满了，则返回 true ，否则返回 false
    public boolean isFull() {
        return size == limit;
    }

    // 指针左移
    private int getLeftIndex(int index) {
        if (index == 0) {
            return limit - 1;
        }
        return index - 1;
    }

    // 指针右移
    private int getRightIndex(int index) {
        if (index == limit - 1) {
            return 0;
        }
        return index + 1;
    }
}
