package com.hh.leetcode.primary.linked;

import com.hh.leetcode.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author HaoHao
 * @date 2022/2/7 8:46 下午
 */
public class RemoveElements {

    /**
     * 递归解法
     * <p>
     * 链表的定义具有递归的性质，因此链表题目常可以用递归的方法求解。这道题要求删除链表中所有节点值等于特定值的节点，可以用递归实现。
     * <p>
     * 对于给定的链表，首先对除了头节点 head 以外的节点进行删除操作，然后判断 head 的节点值是否等于给定的 val。
     * 如果 head 的节点值等于 val，则 head 需要被删除，因此删除操作后的头节点为head.next；
     * 如果 head 的节点值不等于 val，则 head 保留，因此删除操作后的头节点还是 head。
     * 上述过程是一个递归的过程。
     * 递归的终止条件是 head 为空，此时直接返回 head。当 head 不为空时，
     * 递归地进行删除操作，然后判断 head 的节点值是否等于 val 并决定是否要删除 head
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 也可以用迭代的方法删除链表中所有节点值等于特定值的节点。
     *
     * 用 temp 表示当前节点。如果 temp 的下一个节点不为空且下一个节点的节点值等于给定的 val，则需要删除下一个节点。删除下一个节点可以通过以下做法实现：
     * temp.next=temp.next.next
     * 如果 temp 的下一个节点的节点值不等于给定的 val，则保留下一个节点，将 temp 移动到下一个节点即可。
     * 当 temp 的下一个节点为空时，链表遍历结束，此时所有节点值等于 val 的节点都被删除。
     * 具体实现方面，由于链表的头节点 head 有可能需要被删除，因此创建哑节点 dummyHead，令  = dummyHead.next=head，初始化 =temp=dummyHead，然后遍历链表进行删除操作。最终返回 dummyHead.next 即为删除操作后的头节点。
     *
     */
    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        // 创建假节点,方便删除头结点
        ListNode fake = new ListNode(0);
        fake.next = head;

        ListNode cur = fake;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 跳过等值节点
                cur.next = cur.next.next;
            } else {
                // 正常遍历
                cur = cur.next;
            }
        }
        return fake.next;
    }



    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode node = removeElements(head1, 4);
    }

}
