package com.hh.leetcode.linked;

import com.hh.leetcode.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvdwtj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2021/11/22 9:28 下午
 */
public class OddEvenList {

    /**
     * O(n)
     * 根据节点编号的奇偶性，我们可以将奇数节点和偶数节点分离成奇数链表和偶数链表
     * 然后将偶数链表连接在奇数链表之后，合并后的链表即为结果链表。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 奇数链头
        ListNode oddHead = head;
        // 奇数链尾
        ListNode oddTail = head;

        // 偶数链头
        ListNode evenHead = head.next;
        // 偶数链尾
        ListNode evenTail = head.next;

        // 第三个node
        ListNode p = head.next.next;
        // 1 2 3 4 5
        // p = 3
        while (p != null) {
            // 奇数连接
            // 1 3
            oddTail.next = p;
            // 3
            oddTail = oddTail.next;

            // 4
            p = p.next;
            // 偶数连接
            if (p != null) {
                // 2 4
                evenTail.next = p;
                // 2
                evenTail = evenTail.next;
                p = p.next;

            }
        }

        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;

    }
}
