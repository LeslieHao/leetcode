package com.hh.leetcode.linked;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 *
 * @author HaoHao
 * @date 2022/7/17 5:46 下午
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(build);
        LinkedUtil.print(build);
    }

    public void reorderList(ListNode head) {
        // 1.找到链表中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2.反转后半部分
        ListNode mid = slow.next;
        // 断链
        slow.next = null;
        ListNode newHead = null;
        // 暂存下一个需要头插的节点
        ListNode cur = mid;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }

        // 3.合并链表
        ListNode tail = head;

        ListNode left = head;

        ListNode right = newHead;

        left = left.next;

        while (left != null || right != null) {
            if (right != null) {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
            if (left != null) {
                tail.next = left;
                tail = tail.next;
                left = left.next;
            }
        }
    }
}
