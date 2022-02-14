package com.hh.leetcode.recursion;

/**
 * @author HaoHao
 * @date 2022/1/7 9:31 下午
 */
public class Recursion {

    public static int add(int i) {
        if (i <= 1) {
            return i;
        }
        return i + add(i - 1);
    }

    public static int multi(int i) {
        if (i <= 1) {
            return i;
        }
        return i * multi(i - 1);
    }


    /**
     * f(n)= f(n-1)+f(n-2)
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(9));
    }
}
