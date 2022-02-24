package com.hh.leetcode.primary.array;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author HaoHao
 * @date 2022/2/24 4:57 下午
 */
public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // hashMap 记录次数
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], integer + 1);
            }
        }

        // 小顶堆,每次都移除最小的,最后剩下的还是topk
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer integer : map.keySet()) {
            if (priorityQueue.size() >= k) {
                if (map.get(priorityQueue.peek()) < map.get(integer)) {
                    priorityQueue.remove();
                    priorityQueue.add(integer);
                }
            } else {
                priorityQueue.add(integer);
            }
        }
        return priorityQueue.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

}
