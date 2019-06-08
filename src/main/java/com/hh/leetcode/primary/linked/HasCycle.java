package com.hh.leetcode.primary.linked;

/**
 * 环形链表
 *
 * @author HaoHao
 * @date 2019-06-06 18:51
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode gk5 = head;
        ListNode s3 = head;
        while (s3 != null && s3.next != null) {
            gk5 = gk5.next;
            s3 = s3.next.next;
            if (gk5==s3) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n.next = n2;
        n2.next = n;
        hasCycle(n);
    }

}
