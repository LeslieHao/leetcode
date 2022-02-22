package com.hh.leetcode.primary.string;

/**
 * 415. 字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * @author HaoHao
 * @date 2022/2/18 4:02 下午
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        // 双指针,从后往前求和
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        boolean isJinWei = false;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2;
            if (isJinWei) {
                sum++;
                isJinWei = false;
            }
            if (sum > 9) {
                sum = sum % 10;
                isJinWei = true;
            }
            i--;
            j--;
            res.append(sum);
        }
        if (isJinWei) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "1934"));
    }
}
