package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// lc 895.最大频率栈
public class FreqStack {

    private final Map<Integer, List<Integer>> map;

    private final Map<Integer, Integer> countMap;

    private int maxCount;

    // 构造一个空的堆栈
    public FreqStack() {
        map = new HashMap<>();
        countMap = new HashMap<>();
    }

    // 将一个整数 val 压入栈顶
    public void push(int val) {
        int count = countMap.getOrDefault(val, 0);
        countMap.put(val, ++count);
        if (!map.containsKey(count)) {
            map.put(count, new ArrayList<>());
        }
        List<Integer> list = map.get(count);
        list.add(val);
        maxCount = Math.max(maxCount, count);
    }

    // 删除并返回堆栈中出现频率最高的元素
    // 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素
    public int pop() {
        List<Integer> list = map.get(maxCount);
        int result = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(maxCount--);
        }
        int count = countMap.get(result);
        if (count == 1) {
            countMap.remove(result);
        } else {
            countMap.put(result, countMap.get(result) - 1);
        }
        return result;
    }
}
