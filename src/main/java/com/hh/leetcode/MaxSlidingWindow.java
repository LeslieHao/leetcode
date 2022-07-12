package com.hh.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2021/12/16 10:11 下午
 */
public class MaxSlidingWindow {

    // o(nlogk)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 优先队列(k个元素)
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 前k 个先进去
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        // 结果集
        int[] result = new int[nums.length - k + 1];
        // 第一个
        result[0] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            // 去掉一个
            queue.remove(nums[i - k]);
            // 加入一个
            queue.add(nums[i]);

            result[i - k + 1] = queue.peek();
        }
        return result;
    }


    // o(n)
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> deque = new ArrayDeque<>();
        // 结果集
        int[] result = new int[nums.length - k + 1];


        for (int i = 0; i < nums.length; i++) {
            // 保证队列从小到达排列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 出了窗口的要出去
            if (deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            // 从第i=k-1 时开始保存结果
            if (i + 1 >= k) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow2(arr, 3)));
    }

}
