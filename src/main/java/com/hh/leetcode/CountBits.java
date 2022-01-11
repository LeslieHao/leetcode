package com.hh.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/11 11:01 下午
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = countBit(i);
        }
        return arr;
    }

    public int countBit(int n) {
        int c = 0;
        while (n > 0) {
            c++;
            n = n & (n - 1);
        }
        return c;
    }

    public static int[] countBits1(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "," + (i & (i - 1)));
            arr[i] += arr[i & (i - 1)] + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits1(8)));
    }
}
