package com.hh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角2
 *
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * @author HaoHao
 * @date 2022/2/8 2:33 下午
 */
public class GetRow {

    public static List<Integer> getRow(int rowIndex) {
        // 上一层
        List<Integer> pre = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            // 等前层
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
