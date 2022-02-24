package com.hh.practice;

import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @date 2022/2/23 4:17 下午
 */
public class LinkedPractice {


    public static ListNode revert(ListNode head) {
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


}
