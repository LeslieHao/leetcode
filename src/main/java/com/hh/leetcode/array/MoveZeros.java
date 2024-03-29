package com.hh.leetcode.array;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author HaoHao
 * @date 2021/1/28 4:57 下午
 */
public class MoveZeros {
    public static void moveZeroes2(int[] nums) {
        // 从前往后插入,最后补零
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        int last = nums.length - idx;
        for (int i = 0; i <last; i++) {
            nums[idx + i] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        // 从前往后遍历写入新数组,非0 写入,最后补零
        int length = nums.length;
        // 当前赋值的下表
        int index = 0;
        // 遍历
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0,12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
