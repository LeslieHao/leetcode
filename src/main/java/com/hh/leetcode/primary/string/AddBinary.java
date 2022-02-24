package com.hh.leetcode.primary.string;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/2/24 5:20 下午
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());

        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int ca = i > a.length() - 1 ? 0 : a.charAt(a.length() - i - 1) - '0';
            int cb = i > b.length() - 1 ? 0 : b.charAt(b.length() - i - 1) - '0';

            int sum = ca + cb;
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum > 1) {
                carry = true;
            }
            int cc = sum & 1;

            sb.append(cc);
        }
        if (carry) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

}