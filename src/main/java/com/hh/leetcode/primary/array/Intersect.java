package com.hh.leetcode.primary.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 * @author HaoHao
 * @date 2021/1/28 4:37 下午
 */
public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        // hash表记录 数组1 的元素和出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            if (map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        // 遍历nums2
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            if (map.containsKey(n) && map.get(n) > 0) {
                // 保存结果
                res.add(n);
                // 次数减1
                map.put(n, map.get(n) - 1);
            }
        }

        return res.stream().mapToInt(value -> value).toArray();

    }

}
