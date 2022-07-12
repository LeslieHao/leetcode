package com.hh.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * @author HaoHao
 * @date 2021/12/1 10:51 下午
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        // 排序,排序后中间位置肯定是多数元素
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法思路
     * <p>
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     * <p>
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * <p>
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     */
    public static int majorityElement1(int[] nums) {
        int count = 0;
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else if (--count == 0) {
                cur = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            }
        }
        return count > nums.length / 2 ? cur : -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement1(new int[]{1, 2, 3}));
    }

    public int majorityElement2(int[] nums) {
        // map 存储每个元素的个数,最后遍历找到最多的

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer c = 0;
            if ((c = map.get(num)) == null) {
                // 不存在
                c = 1;
            } else {
                c++;
            }
            map.put(num, c);
        }
        Map.Entry<Integer, Integer> maxEntry = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
        return maxEntry.getKey();
    }
}
