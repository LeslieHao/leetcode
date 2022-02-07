package com.hh.leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/28 1:36 下午
 */
public class IsPalindromeNum {

    public static boolean isPalindrome(int x) {
        // 反转字符串,判断是否相等
        StringBuilder reverse = new StringBuilder(x + "").reverse();
        return reverse.toString().equals(x + "");
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        // 末尾为0 直接返回 首位不可能为0
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        // 反转x 的后半部分和前半部分比较
        int lastHalf = 0;
        while (lastHalf < x) {
            // 得到倒数第i位
            int num = x % 10;
            // 存入lastHalf
            lastHalf = lastHalf * 10 + num;
            // x 去掉当前位
            x = x / 10;
        }

        return x == lastHalf || x == lastHalf / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(10));
    }
}
