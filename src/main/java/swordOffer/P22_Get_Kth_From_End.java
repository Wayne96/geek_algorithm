package swordOffer;

import Util.Utils;

public class P22_Get_Kth_From_End {

    public Utils.ListNode getKthFromEnd(Utils.ListNode head, int k) {
        Utils.ListNode former = head;
        Utils.ListNode later = head;

        while (later != null) {
            k--;
            later = later.next;
            if (k < 0) {
                former = former.next;
                //later = later.next;
            }
        }
        return former;
    }


    public static void main(String[] args) {
        Utils.ListNode head = Utils.initList(1, 2, 3, 4, 5);
        Utils.printList(head);
        P22_Get_Kth_From_End p = new P22_Get_Kth_From_End();
        Utils.ListNode node = p.getKthFromEnd(head, 2);
        Utils.printList(node);

    }

}
