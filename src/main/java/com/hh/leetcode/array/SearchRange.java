package com.hh.leetcode.array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author HaoHao
 * @date 2022/2/23 4:32 下午
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int r = binarySearch(nums, target) - 1;
        int l = binarySearch(nums, target - 1);
        if (l <= r && nums[l] == target) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int res = nums.length;
        while (l <= r) {
            mid = (l + r) / 2;
            if (t < nums[mid]) {
                r = mid - 1;
                // 返回第一个>t 的下标
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 7, 9, 10};
    }
}