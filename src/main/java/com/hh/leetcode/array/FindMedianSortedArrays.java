package com.hh.leetcode.array;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * @author HaoHao
 * @date 2022/3/12 5:04 下午
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个有序数组
        int l = 0;
        int r = 0;
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int c = 0;
        while (l < nums1.length || r < nums2.length) {
            if (l < nums1.length && r < nums2.length) {
                if (nums1[l] <= nums2[r]) {
                    arr[c] = nums1[l];
                    l++;
                } else {
                    arr[c] = nums2[r];
                    r++;
                }

            } else if (l < nums1.length) {
                arr[c] = nums1[l];
                l++;

            } else {
                arr[c] = nums2[r];
                r++;
            }
            c++;
        }

        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }

    public static void main(String[] args) {

    }
}

