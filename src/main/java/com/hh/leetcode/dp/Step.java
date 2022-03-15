package com.hh.leetcode.dp;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2018/11/16下午10:40
 */
public class Step {

    /**
     * 其实n 的规律就是斐波那契数列
     */
    public static int climbStairs1(int n) {
        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
        System.out.println(climbStairs2(5));
    }


    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int t = b;
            b = a + b;
            a = t;
        }
        return b;
    }


}
