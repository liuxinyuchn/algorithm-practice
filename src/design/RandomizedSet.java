package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// lc 380.O(1) 时间插入、删除和获取随机元素
public class RandomizedSet {

    private final Map<Integer, Integer> map;

    private final ArrayList<Integer> list;

    // 初始化 RandomizedSet 对象
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // 当元素 val 不存在时，向集合中插入该项，并返回 true；否则，返回 false
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    // 当元素 val 存在时，从集合中移除该项，并返回 true；否则，返回 false
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int valIndex = map.get(val);
        int endValue = list.get(list.size() - 1);
        list.set(valIndex, endValue);
        map.put(endValue, valIndex);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    // 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）
    // 每个元素应该有相同的概率被返回
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
