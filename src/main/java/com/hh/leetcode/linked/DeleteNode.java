package com.hh.leetcode.linked;

import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @Description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例: 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @date 2018/7/21下午3:45
 */
public class DeleteNode {

    /*
        链表至少包含两个节点。
        链表中所有节点的值都是唯一的。
        给定的节点为非末尾节点并且一定是链表中的一个有效节点。
        不要从你的函数中返回任何结果。
     */
    void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
