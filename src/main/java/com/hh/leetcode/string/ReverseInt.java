package com.hh.leetcode.string;

/**
 * 整数翻转
 * @author HaoHao
 * @date 2019-06-06 17:50
 */
public class ReverseInt {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int cur = x % 10;
            res = res * 10 + cur;
            x = x / 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }
}
