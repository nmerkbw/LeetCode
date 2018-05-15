package com.jxs.middle;

/**
 * Created by jiangxs on 2018/5/15.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode x = head;
        int quotient = 0;
        int sum = 0;
        while (l1 != null || l2 != null || quotient != 0) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + quotient;
            quotient = sum / 10;
            x.next = new ListNode(sum % 10);
            x = x.next;
            l1 = l1 != null ? l1.next : l1;

            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;
    }
}

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
