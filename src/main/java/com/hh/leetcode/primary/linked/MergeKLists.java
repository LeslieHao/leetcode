package com.hh.leetcode.primary.linked;

import com.hh.leetcode.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *
 * @author HaoHao
 * @date 2022/3/12 6:06 下午
 */
public class MergeKLists {

    static class Node implements Comparable<Node> {

        int val;

        ListNode listNode;

        public Node(ListNode listNode) {
            this.val = listNode.val;
            this.listNode = listNode;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<Node> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            if (listNode != null) {
                Node node = new Node(listNode);
                queue.add(node);
            }
        }
        ListNode none = new ListNode(0);
        ListNode tail = none;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            tail.next = poll.listNode;
            tail = poll.listNode;
            if (poll.listNode.next != null) {
                queue.add(new Node(poll.listNode.next));
            }
        }
        return none.next;
    }

    public static void main(String[] args) {
    }
}
