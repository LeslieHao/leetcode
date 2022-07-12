package com.hh.leetcode.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author HaoHao
 * @date 2022/2/8 3:12 下午
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (k == 0) {
            return -1;
        }
        
        // 小顶堆,维护k 个元素
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            // 如果大于当前第k 大的
            if (nums[i] > queue.peek()) {
                // 出队然后入队
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return queue.peek();
    }

}
