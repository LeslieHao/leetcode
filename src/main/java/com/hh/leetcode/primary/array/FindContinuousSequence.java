package com.hh.leetcode.primary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author HaoHao
 * @date 2022/2/7 9:08 下午
 */
public class FindContinuousSequence {

    /**
     * 双指针滑动窗口
     * 第一个问题，窗口何时扩大，何时缩小？
     * 第二个问题，滑动窗口能找到全部的解吗？
     * 对于第一个问题，回答非常简单：
     * <p>
     * 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
     * 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
     * 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，那么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1 开头的序列，所以窗口的左边界要向右移动
     */
    public static int[][] findContinuousSequence(int target) {

        // 从1 开始,0 没有实际意义
        int i = 1;
        int j = 1;
        int sum = 1;

        List<int[]> list = new ArrayList<>();
        while (i <= target / 2) {
            // i 最大只能到目标值的二分之一
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    arr[k - i] = k;
                }
                list.add(arr);
                sum -= i;
                i++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }
}
