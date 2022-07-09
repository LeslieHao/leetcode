package com.hh.leetcode;

/**
 * @author HaoHao
 * @Description: 链表通用节点
 * @date 2018/7/21下午3:46
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public static ListNode build(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode now = head;
        for (int i = 1; i < arr.length; i++) {
            now.next = new ListNode(arr[i]);
            now = now.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
