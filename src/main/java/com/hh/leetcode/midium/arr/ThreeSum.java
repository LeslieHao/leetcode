package com.hh.leetcode.midium.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author HaoHao
 * @date 2019-06-24 17:23
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 去重i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 固定值
            int t = nums[i];
            // 左游标
            int l = i+1;
            // 右游标
            int r = nums.length - 1;
            while (l < r) {
                // 左右值
                int lv = nums[l];
                int rv = nums[r];

                int thisSum = lv + rv;
                if ((thisSum + t) == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if ((thisSum + t) < 0) {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }

            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, -2, -1};
        System.out.println(threeSum(nums));

    }
}
