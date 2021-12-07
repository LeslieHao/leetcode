package com.hh.leetcode.primary.linked;

import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @Description: 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @date 2018/8/30下午3:01
 */
public class ReverseList {

    /*
        pre cur next
         1   2   3      1->2->3->4->5
         2   3   4      2->1->3->4->5
         3   4   5      3->2->1->4->5
         4   5   null   4->3->2->1->5
         5  null null   5->4->3->2->1->5
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = null;

        return pre;
    }


    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!= null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
