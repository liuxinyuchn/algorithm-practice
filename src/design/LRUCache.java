package design;

import java.util.HashMap;
import java.util.Map;

// lc 146.LRU 缓存
public class LRUCache {

    private final Map<Integer, Node> map;

    private final NodeList nodeList;

    private final int capacity;

    // 以正整数作为容量 capacity 初始化 LRU 缓存
    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity * 4 / 3);
        this.nodeList = new NodeList();
        this.capacity = capacity;
    }

    // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        nodeList.moveToTail(node);
        return node.val;
    }

    // 如果关键字 key 已经存在，则变更其数据值 value
    // 如果不存在，则向缓存中插入该组 key-value
    // 如果插入操作导致关键字数量超过 capacity ，则应该逐出最久未使用的关键字
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                map.remove(nodeList.removeHead().key);
            }
            Node node = new Node(key, value);
            nodeList.add(node);
            map.put(key, node);
        } else {
            Node node = map.get(key);
            node.val = value;
            nodeList.moveToTail(node);
        }
    }

    static class Node {

        public int key;

        public int val;

        public Node pre;

        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class NodeList {

        public Node head;

        public Node tail;

        public void add(Node node) {
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.pre = tail;
            }
            tail = node;
        }

        public void moveToTail(Node node) {
            if (node == tail) {
                return;
            }
            if (node == head) {
                node.next.pre = null;
                head = node.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

        public Node removeHead() {
            if (head == null) {
                return null;
            }
            Node node = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = node.next;
                node.next.pre = null;
                node.next = null;
            }
            return node;
        }
    }
}
