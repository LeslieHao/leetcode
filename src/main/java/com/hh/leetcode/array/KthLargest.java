package com.hh.leetcode.array;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2021/12/16 9:55 下午
 */
public class KthLargest {

    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    private int k;
    // 优先队列(维护k 个元素的小顶堆)
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        //if (queue.isEmpty()) {
        //    queue.add(val);
        //    return val;
        //}
        //if (queue.size() < k) {
        //    queue.add(val);
        //} else {
        //    // 已经有k 个,判断新来的是否大于堆顶,大于则把堆顶poll,然后入堆
        //    if (queue.peek() < val) {
        //        queue.poll();
        //        queue.add(val);
        //    }
        //}
        //return queue.peek();

        // 直接入堆
        // 如果堆>k,则出去最小的(保持在k个)
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
