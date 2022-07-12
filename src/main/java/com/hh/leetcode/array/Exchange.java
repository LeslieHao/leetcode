package com.hh.leetcode.array;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一
 *
 * @author HaoHao
 * @date 2022/2/9 9:18 下午
 */
public class Exchange {

    /**
     * 双指针
     */
    public static int[] exchange(int[] nums) {
        int i = 0;

        int j = nums.length - 1;
        while (i <= j) {
            int iv = nums[i];
            int jv = nums[j];
            // 奇数对1取模=1
            if ((iv & 1) == 1) {
                i++;
            } else if ((jv & 1) == 0) {
                j--;
            } else {
                // 交换
                nums[i] = jv;
                nums[j] = iv;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
