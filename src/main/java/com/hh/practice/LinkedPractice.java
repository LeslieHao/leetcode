package com.hh.practice;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @date 2022/2/23 4:17 下午
 */
public class LinkedPractice {

    public static void main(String[] args) {
        LinkedUtil.print(revert2(ListNode.build(new int[]{1,2,3,4,5}), 1, 4));
    }

    public static ListNode revert2(ListNode head, int left, int right) {
        ListNode none = new ListNode(-1);
        none.next = head;
        // 子链表的前节点
        ListNode pre = none;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;

        }
        // 子链表的当前尾部
        ListNode childTail = pre.next;

        // 头插
        for (int i = 0; i < (right - left); i++) {
            ListNode node = childTail.next;
            // 尾部头插钱,先连上
            childTail.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }

        return none.next;
    }

    public static ListNode revert(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode node = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = node;
        }
        return newHead;
    }


}
