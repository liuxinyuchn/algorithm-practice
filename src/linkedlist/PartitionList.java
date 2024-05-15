package linkedlist;

// lc 86. 分隔链表
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}
