package swordOffer;

public class P06_Print_ListNode_Head_To_Tail {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] _reversePrint(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int[] arr = new int[list.size()];
//        int j = arr.length - 1;
//        for (int i : list) {
//            arr[j] = list.get(i);
//            j--;
//        }
//        return arr;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int[] arr = new int[len];
        int i = len - 1;
        while (head != null) {
            arr[i] = head.val;
            i--;
            head = head.next;
        }
        return arr;
    }
}
