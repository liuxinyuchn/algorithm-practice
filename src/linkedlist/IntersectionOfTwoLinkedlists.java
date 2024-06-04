package linkedlist;

// lc 160.相交链表
public class IntersectionOfTwoLinkedlists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        int diff = 0;
        while (a.next != null) {
            diff++;
            a = a.next;
        }
        while (b.next != null) {
            diff--;
            b = b.next;
        }
        if (a != b) {
            return null;
        }
        if (diff < 0) {
            b = headA;
            a = headB;
        } else {
            a = headA;
            b = headB;
        }
        diff = Math.abs(diff);
        while (diff-- > 0) {
            a = a.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
