package stack;

import java.util.Stack;

// lc 155.最小栈
// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
public class MinStack {

    private final Stack<Integer> dataStack;

    private final Stack<Integer> minStack;

    // 初始化堆栈对象
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    // 将元素 val 推入堆栈
    public void push(int val) {
        dataStack.push(val);
        if (minStack.empty() || minStack.peek() >= val) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // 删除堆栈顶部的元素
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    // 获取堆栈顶部的元素
    public int top() {
        return dataStack.peek();
    }

    // 获取堆栈中的最小元素
    public int getMin() {
        return minStack.peek();
    }
}
