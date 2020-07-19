package swordOffer;

public class P25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode mark = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mark.next = l1;
                mark = mark.next;
                l1 = l1.next;
            } else {
                mark.next = l2;
                mark = mark.next;
                l2 = l2.next;
            }
        }

        mark.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
