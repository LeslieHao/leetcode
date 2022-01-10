package com.hh.leetcode;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/10 11:03 下午
 */
public class Sqrt {

    /**
     * 由于 x 平方根的整数部分是满足 k^2 <=x^2 的最大 k 值，因此我们可以对 k进行二分查找，从而得到答案。
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // 二分查找
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static double mySqrtWithFloat(int x, double p) {
        if (x == 0 || x == 1) {
            return x;
        }
        // 二分查找
        double left = 0;
        double right = x;
        while (true) {
            double mid = (right + left) / 2;
            double abs = Math.abs(mid - x / mid);
            if (abs < p) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(mySqrtWithFloat(3, 0.1));
    }

}
