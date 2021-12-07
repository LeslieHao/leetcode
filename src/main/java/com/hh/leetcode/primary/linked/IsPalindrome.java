package com.hh.leetcode.primary.linked;

import com.hh.leetcode.ListNode;

import java.util.Stack;

/**
 * @author HaoHao
 * @Description: 请判断一个链表是否为回文链表。
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @date 2018/9/3下午9:01
 */
public class IsPalindrome {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        isPalindrome(node);
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
