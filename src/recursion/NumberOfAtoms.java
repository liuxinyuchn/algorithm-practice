package recursion;

import java.util.TreeMap;

// lc 726.原子的数量
public class NumberOfAtoms {

    private static int where;

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> map = count(formula.toCharArray(), 0);
        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            builder.append(key);
            if (map.get(key) > 1) {
                builder.append(map.get(key));
            }
        }
        return builder.toString();
    }

    private TreeMap<String, Integer> count(char[] array, int i) {
        TreeMap<String, Integer> map = new TreeMap<>();
        int times = 0;
        StringBuilder builder = new StringBuilder();
        TreeMap<String, Integer> pre = null;
        while (i < array.length && array[i] != ')') {
            if (array[i] >= '0' && array[i] <= '9') {
                times = times * 10 + array[i++] - '0';
            } else if (array[i] >= 'a' && array[i] <= 'z') {
                builder.append(array[i++]);
            } else {
                fill(map, builder, pre, times);
                builder.setLength(0);
                times = 0;
                if (array[i] >= 'A' && array[i] <= 'Z') {
                    builder.append(array[i++]);
                } else {
                    pre = count(array, i + 1);
                    i = where + 1;
                }
            }
        }
        fill(map, builder, pre, times);
        where = i;
        return map;
    }

    private void fill(TreeMap<String, Integer> map, StringBuilder builder, TreeMap<String, Integer> pre, int times) {
        if (builder.length() == 0 && pre == null) {
            return;
        }
        times = times == 0 ? 1 : times;
        if (builder.length() != 0) {
            map.put(builder.toString(), map.getOrDefault(builder.toString(), 0) + times);
        } else {
            for (String key : pre.keySet()) {
                map.put(key, map.getOrDefault(key, 0) + pre.get(key) * times);
            }
        }
    }
}
