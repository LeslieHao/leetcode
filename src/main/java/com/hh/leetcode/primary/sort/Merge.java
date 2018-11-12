package com.hh.leetcode.primary.sort;

/**
 * @author HaoHao
 * @date 2018/11/6下午6:56
 */
public class Merge {

    /**
     * 合并两个有序数组
     *
     * @param nums1 足够长
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1;
        int index2 = n - 1;

        while (index2 >= 0) {
            if (index1 < 0) {
                // 数组1 长度为0了,将数组2 所有元素放到前面
                for (int i = 0; i <= index2; i++) {
                    nums1[i] = nums2[i];
                }
                break;
            }

            if (nums1[index1] >= nums2[index2]) {
                nums1[index1 + index2 + 1] = nums1[index1];
                index1--;
            } else {
                nums1[index1 + index2 + 1] = nums2[index2];
                index2--;
            }
        }
    }
}
