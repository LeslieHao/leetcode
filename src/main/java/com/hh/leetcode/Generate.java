package com.hh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * @author HaoHao
 * @date 2022/2/6 5:32 下午
 */
public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            // 计算每一行的值
                // 当前层
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // 首位为1
                    level.add(1);
                } else {
                    // 上一层
                    List<Integer> lastLevel = result.get(i-1);
                    // 上一层的j-1+j
                    int thisValue = lastLevel.get(j - 1) + lastLevel.get(j);
                    level.add(thisValue);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
