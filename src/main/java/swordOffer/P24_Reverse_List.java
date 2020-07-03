package swordOffer;

public class P24_Reverse_List {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public ListNode diGui(ListNode head) {
        // 若果链表为空返回 如果节点下个节点为空 没必要反转返回
        if (head == null || head.next == null) return head;
        // 一个节点 如上一行直接返回
        // 两个节点 返回尾节点
        ListNode p = diGui(head.next);
        // 尾节点指向头结点
        head.next.next = head;
        // 头结点指向空
        head.next = null;
        return p;
    }


}
