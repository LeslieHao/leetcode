package com.hh.leetcode.midium.linked;

import com.hh.leetcode.primary.linked.ListNode;

/**
 * @author HaoHao
 * @date 2019-06-24 18:45
 */
public class GetIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 求出长度差h
        int A = 0;
        int B = 0;
        ListNode shortList = null;
        ListNode longList = null;
        // 高度差
        int h = 0;
        while (headA != null) {
            A++;
            headA = headA.next;
        }
        while (headB != null) {
            B++;
            headB = headB.next;
        }
        if (A > B) {
            longList = headA;
            shortList = headB;
            h = A - B;
        } else {
            h = B - A;
            longList = headB;
            shortList = headA;
        }

        while (h != 0) {
            shortList = shortList.next;
            h--;
        }

        while (shortList != null) {
            if (shortList == longList||shortList.val==longList.val) {
                return shortList;
            }
            shortList = shortList.next;
            longList = longList.next;
        }
        return null;

    }

    public static void main(String[] args) {
        //ListNode a = new ListNode(4);
        //ListNode a = new ListNode(1);
        //ListNode a = new ListNode(8);
        //ListNode a = new ListNode(4);
        //ListNode a = new ListNode(5);
        //ListNode a = new ListNode(4);
        //ListNode a = new ListNode(4);
        //ListNode a = new ListNode(4);

    }

}
