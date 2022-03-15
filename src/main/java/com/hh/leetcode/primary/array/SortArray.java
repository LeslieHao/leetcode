package com.hh.leetcode.primary.array;

/**
 * @author HaoHao
 * @date 2022/3/12 5:38 下午
 */
public class SortArray {

    public static int[] sortArray(int[] nums) {
        // 插入排序
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int j = i;
            // 向前寻找合适的位置插入
            while (j > 0 && nums[j - 1] > t) {
                // 向后移动
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = t;
        }
        return nums;
    }

    public static void main(String[] args) {
        sortArray(new int[]{5, 2, 3, 1});
    }
}
