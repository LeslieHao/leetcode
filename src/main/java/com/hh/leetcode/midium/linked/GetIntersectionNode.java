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
        ListNode tempA = headA;
        ListNode tempB = headB;
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
            h = A - B;
            return getNode(tempB, tempA, h);
        } else {
            h = B - A;
            return getNode(tempA, tempB, h);
        }


    }

    private static ListNode getNode(ListNode shortList, ListNode longList, int h) {
        while (h != 0) {
            longList = longList.next;
            h--;
        }

        while (shortList != null) {
            if (shortList == longList || shortList.val == longList.val) {
                return shortList;
            }
            shortList = shortList.next;
            longList = longList.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);


        ListNode f = new ListNode(5);
        ListNode g = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        f.next = g;
        g.next = b;

        getIntersectionNode(a, f);
    }

}
