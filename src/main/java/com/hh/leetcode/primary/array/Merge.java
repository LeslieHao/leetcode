package com.hh.leetcode.primary.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <p>
 * 合并两个有序数组
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 *
 * @author HaoHao
 * @date 2019-06-11 17:47
 */
public class Merge {

    /**
     * 可以指针设置为从后向前遍历，每次取两者之中的较大者放进nums1最后面
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int curIdx = nums1.length - 1;
        while (i1 >= 0 || i2 >= 0) {
            if (i1 < 0) {
                nums1[curIdx] = nums2[i2];
                curIdx--;
                i2--;
                continue;
            }
            if (i2 < 0) {
                nums1[curIdx] = nums1[i1];
                i1--;
                curIdx--;
                continue;
            }


            if (nums1[i1] >= nums2[i2]) {
                nums1[curIdx] = nums1[i1];
                curIdx--;
                i1--;
            } else {
                nums1[curIdx] = nums2[i2];
                curIdx--;
                i2--;
            }
        }

    }


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
        merge2(a, 4, b, 5);
        System.out.println(Arrays.toString(a));

    }
}
