package com.hh.leetcode.primary.linked;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * @author HaoHao
 * @date 2022/3/10 7:10 下午
 */
public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 链表节点个数
        int n = 1;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        // 成环
        temp.next = head;

        int x = n - (k % n) + 1;

        ListNode res = null;
        while (x > 0) {
            if (x == 1) {
                res = temp.next;
                temp.next = null;
            } else {
                temp = temp.next;

            }
            x--;

        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = LinkedUtil.arrToLinked(new int[]{0, 1, 2});
        LinkedUtil.print(rotateRight(node, 4));
    }

}
