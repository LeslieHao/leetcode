package com.hh.leetcode.linked;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author HaoHao
 * @date 2022/7/14 10:33 下午
 */
public class SortList {

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode left = ListNode.build(new int[]{3, 4, 2, 1});
        LinkedUtil.print(sortList.sortList(left));
    }

    public ListNode sortList(ListNode head) {
        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 右半边的头结点
        ListNode rightHead = slow.next;
        // 断连 分成两段
        slow.next = null;

        // 递归切分(直到切分为单个节点)
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并有序链表
        ListNode curMin = new ListNode(-1);
        ListNode none = curMin;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curMin.next = left;
                left = left.next;
            } else {
                curMin.next = right;
                right = right.next;
            }
            curMin = curMin.next;
        }
        if (left == null) {
            curMin.next = right;
        } else {
            curMin.next = left;

        }
        return none.next;
    }
}
