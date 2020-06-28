package interview;

import java.util.HashSet;

public class P0201 {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2};
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 1; i < a.length; i++) {
            temp.next = new ListNode(a[i]);
            temp = temp.next;
        }
        ListNode k = head;
        do {
            System.out.print(k.val);
            k = k.next;
        } while (k != null);
        System.out.println();
        ListNode listNode = removeDuplicateNodes(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode _removeDuplicateNodes(ListNode head) {//123321
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode now = head.next;
        ListNode mark = head;
        set.add(head.val);
        while (now != null) {
            if (set.contains(now.val)) {
                now = now.next;
                continue;
            }
            set.add(now.val);
            mark.next = now;
            mark = mark.next;
            now = now.next;
        }
        mark.next = null;
        return head;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode now = head;
        while (now != null) {
            ListNode mark = now;
            while (mark.next != null) {
                if (mark.next.val == now.val) {
                    mark.next = mark.next.next;
                } else {
                    mark = mark.next;
                }
            }
            now = now.next;
        }
        return head;
    }


}
