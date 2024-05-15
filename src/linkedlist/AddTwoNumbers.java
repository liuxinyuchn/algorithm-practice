package linkedlist;

// 2. 两数相加
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val)
                    + carry;
            int val = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
