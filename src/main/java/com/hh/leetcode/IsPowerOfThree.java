package com.hh.leetcode;

/**
 *
 * 326. 3 的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author HaoHao
 * @date 2022/2/3 11:34 上午
 */
public class IsPowerOfThree {


    public static boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree2(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(54));
    }

}
