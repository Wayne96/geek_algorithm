package Util;


public class Utils {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    public static ListNode initList(int... elem) {
        ListNode head = new ListNode(elem[0]);
        ListNode next = head;
        for (int i = 1; i < elem.length; i++) {
            next.next = new ListNode(elem[i]);
            next = next.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
