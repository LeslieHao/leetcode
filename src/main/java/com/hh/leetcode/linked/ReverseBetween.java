package com.hh.leetcode.linked;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * 92. 反转链表 II
 * <p>
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * @author HaoHao
 * @date 2022/2/28 2:31 下午
 */
public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode none = new ListNode(-1);
        none.next = head;
        ListNode pre = none;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 头插
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return none.next;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        // write code here
        ListNode none = new ListNode(-1);
        none.next = head;
        ListNode pre = none;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        // 反转头插
        // pre 始终保存前一个节点,不断从后面移动到pre.next
        ListNode cur = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            // 连接后一个节点
            cur.next = next.next;
            // 头插
            next.next = pre.next;
            // 连接前一个节点
            pre.next = next;
        }
        return none.next;

    }

    public static void main(String[] args) {
        ListNode node = LinkedUtil.arrToLinked(new int[]{1, 2, 3, 4, 5});
        //ListNode node1 = reverseBetween(node, 2, 4);
        ListNode node1 = reverseBetween2(node, 2, 4);
        LinkedUtil.print(node1);
    }

}
