package com.hh.leetcode.string;

/**
 * 1221. 分割平衡字符串
 * <p>
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * 示例 4：
 * <p>
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R'
 *
 * @author HaoHao
 * @date 2022/2/18 4:24 下午
 */
public class BalancedStringSplit {


    /**
     * 可以在遍历 s 时用一个变量 d 维护 L 和 R 字符的数量之差，
     * 当 d=0时就说明找到了一个平衡字符串，将答案加一
     */
    public static int balancedStringSplit(String s) {
        int d = 0;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                d++;
            } else {
                d--;
            }
            if (d == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

}
