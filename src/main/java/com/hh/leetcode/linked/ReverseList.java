package com.hh.leetcode.linked;

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

    public static ListNode reverseList3(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        // 上一个节点,也是当前链表的头结点
        ListNode pre = null;
        // 当前遍历到的节点
        ListNode cur = head;
        while (cur != null) {
            // 当前节点的下一个节点
            ListNode next = cur.next;
            // 当前节点的变为反转链表的头结点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        System.out.println(reverseList3(head1).val);

    }


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
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre=null;
        ListNode cur = head;

        while (cur != null) {
            // 暂存当前节点的下一个节点(因为要替换指针)
            ListNode next = cur.next;
            // 当前节点只想前一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
