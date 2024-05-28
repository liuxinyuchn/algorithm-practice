package heap;

import linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// lc 23.合并 K 个升序链表
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.offer(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            if (cur.next != null) {
                heap.offer(cur.next);
            }
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}
