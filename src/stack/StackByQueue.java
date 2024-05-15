package stack;

import java.util.LinkedList;
import java.util.Queue;

// lc 225. 用队列实现栈
public class StackByQueue {

    class MyStack {

        private final Queue<Integer> queue;

        // 初始化
        public MyStack() {
            queue = new LinkedList<>();
        }

        // 将元素 x 压入栈顶
        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        // 移除并返回栈顶元素
        public int pop() {
            return queue.poll();
        }

        // 返回栈顶元素
        public int top() {
            return queue.peek();
        }

        // 如果栈是空的，返回 true；否则，返回 false
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
