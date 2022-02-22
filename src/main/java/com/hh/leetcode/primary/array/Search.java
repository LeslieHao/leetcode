package com.hh.leetcode.primary.array;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * @author HaoHao
 * @date 2022/2/15 3:04 下午
 */
public class Search {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        // 二分法 找到第一个>target 的下标,右边界
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r > 0 && nums[r] != target) {
            return 0;
        }
        int right = l;

        l = 0;
        r = nums.length-1;
        // 二分法 找到第一个=target 的下标
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return right - r - 1;
    }


    public static void main(String[] args) {
        //System.out.println(search(new int[]{5, 7, 7, 8, 8, 10, 11, 12}, 8));
        System.out.println(search(new int[]{-1}, 0));

        //int[] nums = {5, 7, 7, 8, 8, 10, 11, 12};
        //int l = 0;
        //int r = nums.length - 1;
        //int target = 8;
        //while (l <= r) {
        //    int mid = (l + r) / 2;
        //    if (nums[mid] < target) {
        //        l = mid + 1;
        //    } else {
        //        r = mid - 1;
        //    }
        //}
        //System.out.println(l);
        //System.out.println(r);
    }

}
