package com.hh.leetcode.linked;

import com.hh.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 * @author HaoHao
 * @date 2022/3/14 5:07 下午
 */
public class AddInList {

    public ListNode addInList (ListNode head1, ListNode head2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        while(head1!=null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2!=null){
            stack2.push(head2);
            head2 = head2.next;
        }
        // 进位
        int c = 0;
        ListNode last = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||c!=0){
            int a = stack1.isEmpty()?0:stack1.pop().val;
            int b = stack2.isEmpty()?0:stack2.pop().val;
            int sum = a+b+c;
            c = sum/10;
            ListNode cur = new ListNode(sum%10);
            cur.next = last;
            last = cur;
        }
        return last;

    }
}
