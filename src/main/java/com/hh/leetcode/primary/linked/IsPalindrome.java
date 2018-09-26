package com.hh.leetcode.primary.linked;

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

    public static boolean isPalindrome(ListNode head) {
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

        while (bmw.next!=null&&bmw.next.next != null) {
            honda = head.next;
            bmw = bmw.next.next;
        }

        // 此时 本田飞度走到终点或者终点左面的节点(偶数个节点时)


       //链表逆序
        ListNode reverse = reverseList(honda.next);

        honda.next = null;
        while (head.next != null) {
            if (head.val != reverse.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = null;

        return pre;
    }
}
