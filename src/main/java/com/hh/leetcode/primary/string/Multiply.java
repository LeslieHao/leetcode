package com.hh.leetcode.primary.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author HaoHao
 * @date 2020/4/7 4:59 下午
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(multiply("9", "9"));
    }

    /**
     * 竖式 小学乘法
     * <p>
     * 1 2 3
     * 4 5 6
     * --------
     * 7 3 8
     * .....
     */
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // num2 从后往前遍历与num1 相乘
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        String res = "0";

        for (int i = chars2.length - 1; i >= 0; i--) {
            int thisNum = chars2[i] - '0';
            int c = 0;
            // 每一层的结果
            StringBuilder sb = new StringBuilder();
            // 补零
            for (int j = 0; j < chars2.length - 1 - i; j++) {
                sb.append("0");
            }
            // 从后往前相乘
            for (int j = chars1.length - 1; j >= 0 || c != 0; j--) {

                // 当前整数值
                int n1 = j < 0 ? 0 : chars1[j] - '0';
                // 从后往前相乘 加上上一位进未的
                int thisResult = thisNum * n1 + c;
                // 进几
                c = thisResult / 10;
                // 写几
                sb.append(thisResult % 10);
            }
            char[] chars = sb.reverse().toString().toCharArray();

            // 相加时的进几
            int c1 = 0;

            char[] charsRes = res.toCharArray();

            // 这一层的和
            StringBuilder sbThis = new StringBuilder();

            // 逐层相加
            for (int j = chars.length - 1, k = charsRes.length - 1; j >= 0 || k >= 0 || c1 != 0; j--, k--) {
                int a = j < 0 ? 0 : chars[j]-'0';
                int b = k < 0 ? 0 : charsRes[k] - '0';
                int sum = a + b + c1;
                c1 = sum / 10;
                sbThis.append(sum % 10);
            }
            res = sbThis.reverse().toString();

        }
        return res;
    }


}
