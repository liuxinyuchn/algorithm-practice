package linkedlist;

// lc 138.随机链表的复制
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node pre = dummyNode, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            pre.next = cur.next;
            pre = cur.next;
            cur.next = next;
            cur = next;
        }
        return dummyNode.next;
    }

    private static class Node {

        public int val;

        public Node next;

        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
