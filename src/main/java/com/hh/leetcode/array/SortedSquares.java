package com.hh.leetcode.array;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author HaoHao
 * @date 2022/2/9 9:29 下午
 */
public class SortedSquares {

    /**
     * 暴力解法,先平方再排序
     *
     * O(nlogn)
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    /**
     * 双指针,每次比较两个指针对应的数的平方，选择较大的那个逆序放入答案并移动指针
     */
    public static int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        // 从后往前放
        int idx = nums.length - 1;
        while (i <= j) {
            int iv = nums[i];
            int jv = nums[j];
            if (iv * iv > jv * jv) {
                result[idx] = iv * iv;
                i++;
            } else {
                result[idx] = jv * jv;
                j--;
            }
            idx--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-2, -1, 1, 2, 3, 4})));
    }
}
