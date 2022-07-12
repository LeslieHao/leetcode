package com.hh.leetcode.linked;

import com.hh.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HaoHao
 * @Description: 请判断一个链表是否为回文链表。
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @date 2018/9/3下午9:01
 */
public class IsPalindrome {


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next = new ListNode(0);
        System.out.println(isPalindrome3(node));
    }

    private static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            int j = list.size() - i - 1;
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome3(ListNode head) {
        // 快慢指针,快指针到头,慢指针到中点
        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = null;
        ListNode cur = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 反转前半部分链表
            cur.next = pre;
            pre = cur;
            cur = slow;
        }


        if (fast != null) {
            // 奇数
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.next.val == head.val;
        }
        ListNode honda = head;
        ListNode bmw = head;
        // bmw 一次走两个节点
        // 开车

        Stack<ListNode> stack = new Stack<>();
        stack.push(honda);
        while (bmw.next != null && bmw.next.next != null) {
            honda = honda.next;
            bmw = bmw.next.next;
            stack.push(honda);
        }
        // 此时飞度走到中点
        // 奇数个节点,宝马刚好走到尾节点
        if (bmw.next == null) {
            stack.pop();
        }
        while (honda.next != null) {
            honda = honda.next;
            if (honda.val != stack.pop().val) {
                return false;
            }
        }

        return true;
    }


}
