package queue;

import java.util.Stack;

// lc 232. 用栈实现队列
public class QueueByStack {

    static class MyQueue {

        private final Stack<Integer> inStack;

        private final Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        private void inToOut() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        public void push(int x) {
            inToOut();
            inStack.push(x);
        }

        public int pop() {
            inToOut();
            return outStack.pop();
        }

        public int peek() {
            inToOut();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty()
                    && outStack.empty();
        }
    }
}
