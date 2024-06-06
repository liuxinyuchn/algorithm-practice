package design;

import java.util.*;

// lc 381.O(1) 时间插入、删除和获取随机元素 - 允许重复
public class RandomizedCollection {

    private final Map<Integer, Set<Integer>> map;

    private final List<Integer> list;

    // 初始化空的 RandomizedCollection 对象
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // 将一个 val 项插入到集合中，即使该项已经存在。如果该项不存在，则返回 true，否则返回 false
    public boolean insert(int val) {
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        list.add(val);
        set.add(list.size() - 1);
        map.put(val, set);
        return set.size() == 1;
    }

    // 如果存在，从集合中移除一个 val 项。如果该项存在，则返回 true，否则返回 false。
    // 注意，如果 val 在集合中出现多次，我们只删除其中一个
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Set<Integer> set = map.get(val);
        int removeIndex = set.iterator().next();
        int endValue = list.get(list.size() - 1);
        if (val == endValue) {
            set.remove(list.size() - 1);
        } else {
            Set<Integer> endValueSet = map.get(endValue);
            endValueSet.add(removeIndex);
            list.set(removeIndex, endValue);
            set.remove(removeIndex);
            endValueSet.remove(list.size() - 1);
        }
        list.remove(list.size() - 1);
        if (set.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    // 从当前的多个元素集合中返回一个随机元素。每个元素被返回的概率与集合中包含的相同值的数量线性相关
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
