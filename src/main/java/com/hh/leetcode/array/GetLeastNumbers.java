package com.hh.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author HaoHao
 * @date 2022/2/8 2:43 下午
 */
public class GetLeastNumbers {


    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        // 优先队列维护最小的k个数
        if (k == 0) {
            return res;
        }
        // 默认是小顶堆,所以要重写比较器,改成大顶堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 先入队k 个
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        // 从第k+1 个继续
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                // 如果小于队首,也就是比队列中的最大值要小,则入队
                queue.poll();
                queue.add(arr[i]);
            }
        }

        return queue.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{1, 3, 4, 5, 2}, 3)));
    }

}
