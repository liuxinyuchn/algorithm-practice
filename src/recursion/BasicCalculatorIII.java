package recursion;

import java.util.ArrayList;
import java.util.List;

// lc 772.基本计算器Ⅲ
public class BasicCalculatorIII {

    private static int where;

    public int calculate(String s) {
        return calculate(s.toCharArray(), 0);
    }

    private int calculate(char[] array, int i) {
        int cur = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        while (i < array.length && array[i] != ')') {
            if (array[i] >= '0' && array[i] <= '9') {
                cur = cur * 10 + array[i++] - '0';
            } else if (array[i] == '(') {
                cur = calculate(array, i + 1);
                i = where + 1;
            } else {
                push(numbers, operators, cur, array[i++]);
                cur = 0;
            }
        }
        push(numbers, operators, cur, '+');
        where = i;
        return calculate(numbers, operators);
    }

    private int calculate(List<Integer> numbers, List<Character> operators) {
        int ans = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            ans += operators.get(i - 1) == '+' ? numbers.get(i) : -numbers.get(i);
        }
        return ans;
    }

    private void push(List<Integer> numbers, List<Character> operators, int number, char operator) {
        int size = numbers.size();
        if (size == 0 || operators.get(size - 1) == '+' || operators.get(size - 1) == '-') {
            numbers.add(number);
            operators.add(operator);
        } else {
            int topNumber = numbers.get(size - 1);
            int topOperator = operators.get(size - 1);
            if (topOperator == '*') {
                numbers.set(size - 1, topNumber * number);
            } else {
                numbers.set(size - 1, topNumber / number);
            }
            operators.set(size - 1, operator);
        }
    }
}
