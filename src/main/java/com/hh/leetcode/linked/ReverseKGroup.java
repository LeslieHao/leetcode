package com.hh.leetcode.linked;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * @author HaoHao
 * @date 2022/7/9 7:00 下午
 */
public class ReverseKGroup {


    public static void main(String[] args) {
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4, 5});
        LinkedUtil.print(reverseKGroup(build, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode none = new ListNode(0);
        none.next = head;
        ListNode curHead = none;
        ListNode curEnd = none;
        while (curEnd.next != null) {
            // 每次构造一段长度k 的链表
            for (int i = 0; i < k && curEnd != null; i++) {
                curEnd = curEnd.next;
            }
            if (curEnd == null) {
                break;
            }

            // 下一段的开始节点
            ListNode next = curEnd.next;
            // 当前段的头结点,反转之后的尾结点
            ListNode temp = curHead.next;

            // 断连
            curEnd.next = null;

            // 反转这段长度为k 的链表
            curHead.next = revert(curHead);

            // 连接
            temp.next = next;

            // 新的开始
            curHead = temp;
            curEnd = curHead;

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
