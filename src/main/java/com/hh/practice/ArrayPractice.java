package com.hh.practice;

import java.util.*;

/**
 * @author HaoHao
 * @date 2022/7/5 3:23 下午
 */
public class ArrayPractice {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort(new int[]{2, 1, 3, 4, 3, 5, 2, 3, 10})));
    }


    public static int[] insertSort(int[] nums){
        // 插入排序
        for (int i = 1; i < nums.length; i++) {
            int curNums = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > curNums) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = curNums;
        }
        return nums;
    }

    public void rotate(int[] nums, int k) {
        // 向右移动k
        // 1 2 3 4 5
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int curLast = nums[nums.length - 1];
            // 循环往后移一位
            for (int j = 1; j < nums.length; j++) {
                nums[j] = nums[j - 1];
            }
            nums[0] = curLast;
        }
    }


    public static int missingNumber(int[] nums) {
        // 缺失数字,二分,二分点=下标 则缺失数字在右边
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] != mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static int maxLength(int[] arr) {
        // 最长无重复子数组
        if (arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                startIndex = map.get(num) + 1;
            }
            map.put(num, i);
            res = Math.max(res, i - startIndex + 1);
        }
        return res;
    }


    public static int maxArea(int[] height) {
        int area = 0;
        // 双指针
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int temp = Math.min(height[l], height[r]) * (r - l);
            area = Math.max(temp, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }


    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int l = 0;
        int r = 0;
        // 遍历,以每个元素为中心点扩散得到回文子串
        for (int i = 0; i < chars.length; i++) {
            // 单中心点扩散
            int singleChildLength = getChildLength(chars, i, i);
            // 双中心点扩散
            int doubleChildLength = getChildLength(chars, i, i + 1);
            if (singleChildLength > doubleChildLength) {
                if (r - l + 1 < singleChildLength) {
                    l = i - singleChildLength / 2;
                    r = i + singleChildLength / 2;
                }
            } else {
                if (r - l + 1 < doubleChildLength) {
                    l = i - doubleChildLength / 2 + 1;
                    r = i + doubleChildLength / 2;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static int getChildLength(char[] chars, int l, int r) {
        while (l >= 0 && r <= chars.length - 1 && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }


    /**
     * 3,2,3,1,2,4,5,5,6
     */
    public static int findKthLargest(int[] nums, int k) {
        // 小顶堆,维护k 个元素
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }


    /**
     * [2,3,1,1,4]
     * max = 2
     */
    public static boolean canJump(int[] nums) {
        int max = nums[0];
        // 贪心
        for (int i = 1; i < nums.length; i++) {
            if (i < max) {
                max = Math.max(nums[i] + i, max);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
