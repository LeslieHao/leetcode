package com.hh.leetcode.array;

import java.util.*;

/**
 * 414. 第三大的数
 * <p>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * @author HaoHao
 * @date 2022/2/11 3:12 下午
 */
public class ThirdMax {

    public static int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) {
                // 超过3 个 把最小的删掉
                treeSet.remove(treeSet.first());
            }
        }
        if (treeSet.size() < 3) {
            return treeSet.last();
        }
        return treeSet.first();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1, 2}));
    }
}
