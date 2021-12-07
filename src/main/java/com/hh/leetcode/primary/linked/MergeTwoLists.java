package com.hh.leetcode.primary.linked;


import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2018/9/3下午8:26
 */
public class MergeTwoLists {

    /**
     * 递归合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        head = l1.val < l2.val ? l1 : l2;
        head.next = l1.val < l2.val ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);
        return head;
    }


}
