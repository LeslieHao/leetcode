package com.hh.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 * @author HaoHao
 * @date 2022/7/19 8:46 下午
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        RemoveKdigits test = new RemoveKdigits();
        System.out.println(test.removeKdigits("10", 2));
    }

    public String removeKdigits(String num, int k) {

        Deque<Character> deque = new ArrayDeque<>();

        int kBackup = k;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // 向前找到第一个比当前小的数字
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        // 此时从前到k位置的数字就是最小值

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < (num.length() - kBackup); i++) {
            if (!deque.isEmpty()) {
                if (res.length() == 0 && deque.peekFirst() == '0') {
                    deque.pollFirst();
                } else {
                    res.append(deque.pollFirst());
                }
            } else {
                break;
            }
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
