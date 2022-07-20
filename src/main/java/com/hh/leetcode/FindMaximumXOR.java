package com.hh.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [2,4]
 * 输出：6
 * 示例 4：
 *
 * 输入：nums = [8,10,2]
 * 输出：10
 * 示例 5：
 *
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 105
 * 0 <= nums[i] <= 231 - 1
 *
 * @author HaoHao
 * @date 2022/7/14 9:15 下午
 */
public class FindMaximumXOR {

    public static void main(String[] args) {
        System.out.println(18*200*0.6);

        FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
        findMaximumXOR.findMaximumXOR1(new int[]{2, 3, 4});
    }


    public int findMaximumXOR1(int[] nums) {
        // a^b=c 测 a^c=b

        int res = 0;

        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            // 低位掩码 (前缀)
            mask = mask | 1 << i;

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 取& 得到每个数的前缀
                set.add(num & mask);
            }

            // 当前的前缀
            int temp = res | 1 << i;

            for (Integer pre : set) {
                // 判断集合里又没前缀能匹配的
                if (set.contains(pre ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }



        return res;
    }
    public int findMaximumXOR(int[] nums) {
        // 暴力解法
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }
}
