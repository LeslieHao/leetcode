package com.hh.leetcode;

/**
 *
 * 67. 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 *
 *
 * 示例1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/2/6 5:46 下午
 */
public class AddBinary {

    /**
     * 整体思路是将两个字符串较短的用 0 补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果。
     *
     * 本题解中大致思路与上述一致，但由于字符串操作原因，不确定最后的结果是否会多出一位进位，所以会有 2 种处理方式：
     *
     * 第一种，在进行计算时直接拼接字符串，会得到一个反向字符，需要最后再进行翻转
     * 第二种，按照位置给结果字符赋值，最后如果有进位，则在前方进行字符串拼接添加进位
     *
     * 时间复杂度：O(n)
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        // 最长长度
        int n = Math.max(a.length(), b.length());

        for (int i = 0; i < n; i++) {


        }
        return "";
    }
}
