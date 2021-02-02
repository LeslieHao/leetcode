package com.hh.leetcode.primary.array;

import java.util.Arrays;

/**
 * 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author HaoHao
 * @date 2021/1/28 5:21 下午
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        // 从后往前遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            // 9 则赋值为0
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // 比如109 这里刚好进入第二次循环=110
                // 总归会有一位+1
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        // 遍历完成,则说明所有位都是9 则数组长度加1 第一位=1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(arr)));

    }

}
