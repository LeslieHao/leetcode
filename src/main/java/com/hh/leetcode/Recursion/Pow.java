package com.hh.leetcode.Recursion;

/**
 * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn ）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/7 10:01 下午
 */
public class Pow {

    /**
     * 暴力解法,O(n)
     */
    public static double myPow(double x, int n) {
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    public static double myPow1(double x, int n) {
        if (n > 0) {
            return quickMulti(x, n);
        } else {
            return 1 / quickMulti(x, -n);
        }
    }

    /**
     * 分治 O(logn)
     */
    public static double quickMulti(double x, int n) {
        // 上一层n=1 时 return
        if (n == 0) {
            return 1;
        }
        double y = quickMulti(x, n / 2);
        if (n % 2 == 0) {
            // 偶数
            return y * y;
        } else {
            return x * y * y;
        }
    }

    /**
     * 分治非递归解法
     */
    public static double myPow2(double x, int n) {
        if (x == 0) {
            return x;
        }
        long b = n;
        double res = 1;
        // 负指数幂情况
        if (b  < 0) {
            x = 1 / x;
            b  = -b ;
        }
        // ((x^2)^2)^2...j层,2^j =b , 如果是奇数再多乘一个x
        while (b  > 0) {
            if ((b  & 1) == 1) {
                // 奇数
                res = res * x;
            }
            x = x * x;
            // b /2
            b  = b  >> 1;
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(myPow2(2, 4));
    }
}
