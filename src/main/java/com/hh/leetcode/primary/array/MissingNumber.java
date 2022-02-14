package com.hh.leetcode.primary.array;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class MissingNumber {

    /**
     * 只要比较数组下标和该下标对应的值即可，再排除缺失0和缺失最后一项两个特殊情况
     */
    public static int missingNumber(int[] nums) {
        if (nums[0] == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 有序数组查找一定二分!
     * 找缺失点
     * 缺失点往后的数组下标和值对应不上
     *
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{0, 1, 3, 4, 5, 6}));
    }
}
