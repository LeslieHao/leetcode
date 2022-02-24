package com.hh.leetcode;

/**
 * @author HaoHao
 * @date 2022/2/15 4:41 下午
 */
public class LinkedUtil {

    public static ListNode arrToLinked(int[] arr) {
        ListNode fake = new ListNode(-1);
        ListNode pre = fake;
        for (int i : arr) {
            ListNode listNode = new ListNode(i);
            pre.next = listNode;
            pre = listNode;
        }
        return fake.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = arrToLinked(new int[]{1, 2, 3, 4, 5});
        System.out.println(listNode);
    }

}
