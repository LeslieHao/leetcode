package com.hh.leetcode.array;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * @author HaoHao
 * @date 2022/7/18 10:40 下午
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        System.out.println(test.firstMissingPositive(new int[]{3, 2}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }

        int[] dic = new int[nums.length + 1];

        // 把>=1 <=nums.length 的存入顺序字典
        for (int num : nums) {
            if (num >= 1 && num <= nums.length) {
                dic[num] = num;
            }
        }
        // 遍历字典,如果位置缺失则返回
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] != i) {
                return i;
            }
        }
        // 全都是正整数且从1连续,返回n+1
        return dic.length;

    }
}
