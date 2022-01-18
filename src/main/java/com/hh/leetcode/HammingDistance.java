package com.hh.leetcode;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/17 9:43 下午
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        // 异或
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance1(int x, int y) {
        int res = x ^ y;
        // 计数res 中有多少个 1
        int c = 0;
        while (res != 0) {
            if ((res & 1) == 1) {
                // n&1=1 则n的最低位为1
                c++;
            }
            res = res >> 1;
        }
        return c;
    }


    public static void main(String[] args) {
        System.out.println(Integer.bitCount(1 ^ 4));
        System.out.println(Integer.toBinaryString(4));
    }


}
