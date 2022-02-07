package com.hh.leetcode;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * @author HaoHao
 * @date 2022/2/3 4:43 下午
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                // 遇到重复,cur 不动,只去重
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
