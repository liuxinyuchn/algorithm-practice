package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// lc 432.全 O(1) 的数据结构
public class AllOne {

    private final Bucket head;

    private final Bucket tail;

    private final Map<String, Bucket> map;

    // 初始化数据结构的对象
    public AllOne() {
        this.head = new Bucket(0, "");
        this.tail = new Bucket(Integer.MAX_VALUE, "");
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>();
    }

    // 字符串 key 的计数增加 1。
    // 如果数据结构中尚不存在 key，那么插入计数为 1 的 key
    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next.count == 1) {
                head.next.set.add(key);
                map.put(key, head.next);
            } else {
                Bucket bucket = new Bucket(1, key);
                insert(head, bucket);
                map.put(key, bucket);
            }
        } else {
            Bucket cur = map.get(key);
            if (cur.next.count == cur.count + 1) {
                cur.next.set.add(key);
                map.put(key, cur.next);
            } else {
                Bucket bucket = new Bucket(cur.count + 1, key);
                insert(cur, bucket);
                map.put(key, bucket);
            }
            cur.set.remove(key);
            if (cur.set.isEmpty()) {
                remove(cur);
            }
        }
    }

    // 字符串 key 的计数减少 1。
    // 如果 key 的计数在减少后为 0，那么需要将这个 key 从数据结构中删除。
    public void dec(String key) {
        Bucket cur = map.get(key);
        if (cur.count == 1) {
            map.remove(key);
        } else {
            if (cur.pre.count == cur.count - 1) {
                cur.pre.set.add(key);
                map.put(key, cur.pre);
            } else {
                Bucket bucket = new Bucket(cur.count - 1, key);
                insert(cur.pre, bucket);
                map.put(key, bucket);
            }
        }
        cur.set.remove(key);
        if (cur.set.isEmpty()) {
            remove(cur);
        }
    }

    // 返回任意一个计数最大的字符串。
    // 如果没有元素存在，返回一个空字符串 ""
    public String getMaxKey() {
        return tail.pre.set.iterator().next();
    }

    // 返回任意一个计数最小的字符串。
    // 如果没有元素存在，返回一个空字符串 ""
    public String getMinKey() {
        return head.next.set.iterator().next();
    }

    private void insert(Bucket cur, Bucket pos) {
        pos.next = cur.next;
        cur.next.pre = pos;
        cur.next = pos;
        pos.pre = cur;
    }

    private void remove(Bucket cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.pre = null;
        cur.next = null;
    }

    static class Bucket {

        public int count;

        public Set<String> set;

        public Bucket pre;

        public Bucket next;

        public Bucket(int count, String s) {
            this.set = new HashSet<>();
            this.set.add(s);
            this.count = count;
        }
    }
}
