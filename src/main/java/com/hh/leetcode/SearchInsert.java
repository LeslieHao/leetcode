package com.hh.leetcode;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/2/3 11:56 上午
 */
public class SearchInsert {

    /**
     * 二分法找到
     * nums[pos−1]<target≤nums[pos]
     */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int idx = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println(mid);
            if (target <= nums[mid]) {
                r = mid - 1;
                idx = mid;
            } else {
                l = mid + 1;
            }
        }
        return idx;

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{0, 1, 3, 7, 8}, 3));
    }


}
