package com.hh.leetcode.linked;

import com.hh.leetcode.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * @author HaoHao
 * @date 2021/12/7 8:50 下午
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 啥节点?
        ListNode sha = new ListNode(0);

        sha.next = head;

        ListNode temp = sha;

        while (temp.next != null && temp.next.next != null) {

            ListNode a = temp.next;

            ListNode b = temp.next.next;

            // 前连接
            temp.next = b;

            // 后连接
            a.next = b.next;

            // 交换
            b.next = a;

            temp = a;
        }
        return sha.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4});
        swapPairs(head);
    }
}
