package com.hh.leetcode.linked;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * @author HaoHao
 * @date 2022/2/28 4:39 下午
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode none = new ListNode(-1);
        none.next = head;

        ListNode cur = none;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return none.next;
    }

    public static void main(String[] args) {
        ListNode node = LinkedUtil.arrToLinked(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode node1 = deleteDuplicates(node);
        LinkedUtil.print(node1);
    }
}
