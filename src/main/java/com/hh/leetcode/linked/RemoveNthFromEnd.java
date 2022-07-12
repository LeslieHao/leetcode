package com.hh.leetcode.linked;

import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例: 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @date 2018/7/21下午3:52
 */
public class RemoveNthFromEnd {

    /*
        说明：给定的 n 保证是有效的。
        进阶：你能尝试使用一趟扫描实现吗
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        // a b 两个点 a 先出法n 步然后b 出发,a 到达终点时候.
        ListNode nodeA = head;

        // b
        ListNode nodeB = head;
        // a 领先的节点数
        int step = 0;
        //nodeA 先走n-1步
        while (step < n) {
            step++;
            nodeA = nodeA.next;
        }

        // 链表长度等于n 删除头结点
        if (nodeA == null) {
            head = head.next;
            return head;
        }

        // b开始走
        while ( nodeA.next != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        // b 当前节点就是倒数第n+1 个节点

        nodeB.next = nodeB.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        removeNthFromEnd(head, 1);
    }





}
