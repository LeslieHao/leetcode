package com.hh.leetcode.array;

import java.util.*;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author HaoHao
 * @date 2019-06-24 17:23
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 去重i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 固定值
            int t = nums[i];
            // 左游标
            int l = i + 1;
            // 右游标
            int r = nums.length - 1;
            while (l < r) {
                // 左右值
                int lv = nums[l];
                int rv = nums[r];

                int thisSum = lv + rv;
                if ((thisSum + t) == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if ((thisSum + t) < 0) {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }

            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序,然后枚举a,然后从后面找b+c=-a
        if (nums.length < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 左右下标向中间汇聚
            int l = i + 1;
            int r = nums.length - 1;
            if (l > (nums.length - 1)) {
                break;
            }
            int curSum = nums[i] + nums[l] + nums[r];
            while (l != r) {
                if (curSum > 0) {
                    // 大于零,r向左
                    r--;
                } else if (curSum < 0) {
                    // 小于0 l向右
                    l++;
                } else {
                    // =0
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                }
                curSum = nums[i] + nums[l] + nums[r];
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        // 枚举a+b 的值,然后去map里找-(a+b)
        List<List<Integer>> list = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && i != j; j++) {
                int sum = nums[i] + nums[j];
                // 目标下标
                Integer targetIndex;
                if ((targetIndex = map.get(-sum)) != null
                        && nums[i] != nums[j]
                        && nums[j] != nums[targetIndex]
                        && nums[i] != nums[targetIndex]) {
                    // 存在sum的相反数
                    List<Integer> childs = new ArrayList<>();
                    childs.add(nums[i]);
                    childs.add(nums[j]);
                    childs.add(nums[targetIndex]);
                    list.add(childs);
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 2,-2};
        System.out.println(threeSum3(nums));
        char a = '1';

    }
}
