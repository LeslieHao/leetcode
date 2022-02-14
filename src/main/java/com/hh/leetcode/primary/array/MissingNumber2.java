package com.hh.leetcode.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 *
 * 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 *
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * @author HaoHao
 * @date 2022/2/11 2:42 下午
 */
public class MissingNumber2 {

    /**
     * 排序后找到下标不一致的第一个
     * O(nlogn)
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[nums.length - 1] + 1;
    }


    /**
     * hash表解法
     * <p>
     * 首先遍历数组 nums，将数组中的每个元素加入哈希集合，
     * 然后依次检查从 0 到 n 的每个整数是否在哈希集合中，不在哈希集合中的数字即为丢失的数字。
     * 由于哈希集合的每次添加元素和查找元素的时间复杂度都是 O(1)，
     * 因此总时间复杂度是 O(n)O(n)。
     */
    public static int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{0,1,3}));
    }
}
