package linkedlist;

// lc 25.K 个一组翻转链表
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode start = head, lastEnd = dummyNode, end = findEnd(dummyNode, k);
        while (end != null) {
            ListNode tmp = end.next;
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
            start = tmp;
            end = findEnd(lastEnd, k);
        }
        return dummyNode.next;
    }

    private ListNode findEnd(ListNode node, int k) {
        while (k-- > 0 && node != null) {
            node = node.next;
        }
        return node;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode pre = null, cur = start, e = end.next, next;
        while (cur != e) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = e;
    }
}
