package com.hh.leetcode.midium.linked;

import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @date 2019-06-24 18:45
 */
public class GetIntersectionNode {

    /**
     * 走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }

            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }


    /**
     * 这种解法只适合仅当相交时值相等的情况
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 求出长度差h
        int A = 0;
        int B = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        // 长度差
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
            if (shortList == longList) {
                return shortList;
            }
            shortList = shortList.next;
            longList = longList.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 4, 5};
        int[] arr2 = {5, 6, 1, 8, 4, 5};

        ListNode node = getNode(arr1);
        ListNode node1 = getNode(arr2);
        System.out.println(getIntersectionNode1(node, node1).val);
    }

    private static ListNode getNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }

}
