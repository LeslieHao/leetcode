package com.hh.leetcode.primary.array;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author HaoHao
 * @date 2022/2/11 4:18 下午
 */
public class TwoSum2 {

    /**
     * 双指针
     * 初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
     * 每次计算两个指针指向的两个元素之和，并和目标值比较。如果两个元素之和等于目标值，则发现了唯一解。
     * 如果两个元素之和小于目标值，则将左侧指针右移一位。如果两个元素之和大于目标值，则将右侧指针左移一位。
     * 移动指针之后，重复上述操作，直到找到答案
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int curSum = numbers[l] + numbers[r];
            if (curSum == target) {
                return new int[]{l + 1, r + 1};
            } else if (curSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }
}
