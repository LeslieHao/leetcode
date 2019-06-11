package com.hh.leetcode.primary.array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author HaoHao
 * @date 2019-06-11 17:47
 */
public class Merge {

    // 从后往前合并
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (m == 0 && n == 0) {
                return;
            }

            if (m == 0) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if (n == 0) {
                nums1[i] = nums1[m - 1];
                m--;
                continue;
            }

            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 0, 0, 0, 0, 0};
        int[] b = {2, 3, 4, 5, 6};
        merge(a, 4, b, 5);
        System.out.println(Arrays.toString(a));

    }
}
