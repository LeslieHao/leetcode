package com.hh.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author HaoHao
 * @date 2022/2/3 4:28 下午
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        // 借助栈
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.push(head);
            head = head.next;
        }
        return deque.stream().mapToInt(listNode -> listNode.val).toArray();
    }

    public static int[] reversePrint2(ListNode head) {
        // 获取长度
        int l = 0;
        ListNode headStore = head;
        while (head != null) {
            l++;
            head = head.next;

        }
        // 遍历,然后从数组最后开始存入
        int[] arr = new int[l];
        int i = 0;
        while (headStore != null) {
            arr[l - i - 1] = headStore.val;
            headStore = headStore.next;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        System.out.println(Arrays.toString(reversePrint2(head1)));

    }

}
