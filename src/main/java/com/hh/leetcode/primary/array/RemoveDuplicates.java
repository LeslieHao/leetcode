package com.hh.leetcode.primary.array;

/**
 * @author HaoHao
 * @Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例:给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * @date 2018/7/21下午3:41
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }

        count += 1;

        return count;
    }
}
