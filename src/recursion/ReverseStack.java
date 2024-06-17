package recursion;

import java.util.Stack;

// 反转栈
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);
    }

    private static int bottomOut(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.empty()) {
            return ans;
        }
        int last = bottomOut(stack);
        stack.push(ans);
        return last;
    }
}
