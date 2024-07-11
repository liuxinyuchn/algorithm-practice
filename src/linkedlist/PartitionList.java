package linkedlist;

// lc 86. 分隔链表
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(), right = new ListNode(), curL = left, curR = right;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                curL.next = head;
                curL = curL.next;
            } else {
                curR.next = head;
                curR = curR.next;
            }
            head = next;
        }
        curL.next = right.next;
        return left.next;
    }
}
