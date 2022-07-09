package com.hh.leetcode.primary.array;

/**
 * NC36 在两个长度相等的排序数组中找到上中位数
 *
 * 描述
 * 给定两个递增数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 * 上中位数：假设递增序列长度为n，为第n/2个数
 *
 * 示例1
 * 输入：
 * [1,2,3,4],[3,4,5,6]
 *
 * 返回值：
 * 3
 *
 * 说明：
 * 总共有8个数，上中位数是第4小的数，所以返回3。
 * 示例2
 * 输入：
 * [0,1,2],[3,4,5]
 *
 * 返回值：
 * 2
 *
 * 说明：
 * 总共有6个数，那么上中位数是第3小的数，所以返回2
 * 示例3
 * 输入：
 * [1],[2]
 *
 * 返回值：
 * 1
 *
 *
 * 要求：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
 * 进阶：时间复杂度为O(logN)O(logN)，空间复杂度为O(1)O(1)
 *
 * @author HaoHao
 * @date 2022/3/23 4:19 下午
 */
public class FindMedianinTwoSortedArray {

    public static int findMedianinTwoSortedArray(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int mid = len >> 1;

        int count = 0;
        int res = 0;

        int l = 0;
        int r = 0;

        while (count != mid) {
            if (arr1[l] > arr2[r]) {
                res = arr2[r];
                r++;
            } else {
                res = arr1[l];
                l++;
            }

            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMedianinTwoSortedArray(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}));
    }
}
