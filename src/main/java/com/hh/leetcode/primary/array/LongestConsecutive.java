package com.hh.leetcode.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * @author HaoHao
 * @date 2022/3/3 3:13 下午
 */
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            // 不连续则从头计算
            if (!set.contains(num - 1)) {
                int curMax = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    curMax++;
                    curNum++;
                }
                max = Math.max(max, curMax);
            }

        }
        return max;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums == null||nums.length==0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int max = 1;
        int curMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur != (nums[i - 1] + 1) && cur != (nums[i - 1])) {
                curMax = 1;
            }else if (cur == (nums[i - 1])){

            }else {
                curMax++;
                max = Math.max(max, curMax);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[]{1,2,0,1}));
    }
}
