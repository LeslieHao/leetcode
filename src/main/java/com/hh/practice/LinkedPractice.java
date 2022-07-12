package com.hh.practice;

import com.hh.leetcode.LinkedUtil;
import com.hh.leetcode.ListNode;

/**
 * @author HaoHao
 * @date 2022/2/23 4:17 下午
 */
public class LinkedPractice {

    public static void main(String[] args) {
        LinkedPractice practice = new LinkedPractice();
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4, 5,6});

        LinkedUtil.print(practice.revertKGroup(build,3));
    }


    public ListNode revertKGroup(ListNode head, int k) {
        ListNode none = new ListNode(-1);
        none.next = head;
        // 构造k 长度的链表 断连 反转 连接
        // 当前子链表的前一个节点
        ListNode curHeadPre = none;
        ListNode curTail = none;
        while (curTail.next != null) {
            // 构造长度为k 的字链表
            for (int i = 0; i < k && curTail.next != null; i++) {
                curTail = curTail.next;
            }
            // 下一段的头结点
            ListNode nextHead = curTail.next;


            // 下个前置节点
            ListNode newPre = curHeadPre.next;
            // 断联
            curTail.next = null;
            // 反转,前面连接
            curHeadPre.next = revert2(curHeadPre.next);

            // 后面连接
            newPre.next = nextHead;

            curHeadPre = newPre;
            curTail = newPre;
        }

        return none.next;
    }

    public ListNode revert2(ListNode node) {
        // 当前头
        ListNode curHead = null;
        // 下一个需要头插的节点
        ListNode next = node;
        while (next != null) {
            // 暂存下一个要头插的节点
            ListNode temp = next.next;
            // 头插
            next.next = curHead;
            // 替换最新头结点
            curHead = next;
            // 下一个要头插的节点
            next = temp;
        }
        return curHead;
    }

    public ListNode revertBetween(ListNode head, int left, int right) {
        // 哑节点
        ListNode none = new ListNode(-1);
        none.next = head;
        // 反转部分的前一个节点
        ListNode pre = none;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 头插
        // 反转部分的尾结点
        ListNode curTail = pre.next;
        for (int i = 0; i < right - left; i++) {
            // 反转部分的头结点
            ListNode curHead = pre.next;
            // 需要头插的节点
            ListNode next = curTail.next;
            // 尾结点跳一个节点连接
            curTail.next = next.next;
            // 头插
            pre.next = next;
            next.next = curHead;
        }

        return none.next;
    }

    public ListNode revert2(ListNode head, int left, int right) {
        ListNode none = new ListNode(-1);
        none.next = head;
        // 子链表的前节点
        ListNode pre = none;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;

        }
        // 子链表的当前尾部
        ListNode childTail = pre.next;

        // 头插
        for (int i = 0; i < (right - left); i++) {
            ListNode node = childTail.next;
            // 尾部头插前,先连上
            childTail.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }

        return none.next;
    }

    public ListNode revert(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode node = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = node;
        }
        return newHead;
    }


}
