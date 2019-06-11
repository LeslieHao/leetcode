package com.hh.leetcode.primary.dynamic;

/**
 * 爬楼梯
 * 1 2 3 5 8
 * @author HaoHao
 * @date 2018/11/16下午10:40
 */
public class Step {

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
