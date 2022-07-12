package com.hh.leetcode.linked;


import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2018/9/3下午8:26
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode listNode1 = LinkedUtil.arrToLinked(new int[]{1, 3, 4, 5});
        ListNode listNode2 = LinkedUtil.arrToLinked(new int[]{2, 4, 4, 6});
        System.out.println(mergeTwoLists2(listNode1, listNode2));
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode fake = new ListNode(-1);
        ListNode pre = fake;
        while (list1 != null && list2 != null) {
            // 两个链表同时不为空
            if (list1.val <= list2.val) {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return fake.next;
    }

    /**
     * 递归合并
     *
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
