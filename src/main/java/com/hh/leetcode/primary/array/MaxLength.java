package com.hh.leetcode.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * NC41 最长无重复子数组
 * <p>
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * <p>
 * [2,3,4,5,4]
 * <p>
 * 返回值：
 * 4
 * 说明：
 * [2,3,4,5]是最长子数组
 *
 * @author HaoHao
 * @date 2022/3/14 4:37 下午
 */
public class MaxLength {

    public int maxLength(int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int l = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                int idx = map.get(num);
                l = Math.max(l, idx + 1);
            }
            map.put(num, i);
            res = Math.max(i - l + 1, res);
        }
        return res;

    }
}
