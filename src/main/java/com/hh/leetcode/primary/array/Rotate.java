package com.hh.leetcode.primary.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * @author HaoHao
 * @date 2018/7/21下午3:43
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (k > 0) {
            int len = nums.length;
            k = k % len;
            for (int i = 0; i < k; i++) {
                int temp = nums[len - 1];
                for (int j = len - 1; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = temp;
            }
        }
    }
}
