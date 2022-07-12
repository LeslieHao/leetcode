package com.hh.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author HaoHao
 * @date 2019-06-24 17:24
 */
public class TwoSum {

    // map get O(1)
    public static int[] twoSum(int[] nums, int target) {
        // map k=val v=index

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            //
            Integer t;
            if (( t = map.get(target - temp))!=null) {
                return new int[]{i, t};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum2 (int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            int cur=numbers[i];
            if(map.containsKey(cur)){
                return new int[]{map.get(cur),i+1};
            }else{
                map.put(target-cur,i+1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }

}
