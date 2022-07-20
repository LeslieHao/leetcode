package com.hh.leetcode;

import java.util.Arrays;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 *
 * @author HaoHao
 * @date 2022/7/20 10:16 下午
 */
public class ArraySort {

    public static void main(String[] args) {
        ArraySort test = new ArraySort();
        int[] array = test.sortArray(new int[]{1, 3, 2, 4, -1});
        System.out.println(Arrays.toString(array));
    }

    public int[] sortArray(int[] nums) {
        this.mergeSort(nums);
        return nums;
    }

    int[] temp;

    /**
     * 归并排序
     *
     * @param nums
     */
    public void mergeSort(int[] nums) {
        int len = nums.length;
        temp = new int[nums.length];
        doMergeSort(nums, 0, len - 1);
    }

    private void doMergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        // 递归归并
        doMergeSort(nums, l, mid);
        doMergeSort(nums, mid + 1, r);
        // 合并两个有序数组,l-mid,mid-r
        int i = l;
        int j = mid + 1;
        int count = 0;
        // 存到临时数组temp
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[count] = nums[i];
                i++;
            } else {
                temp[count] = nums[j];
                j++;
            }
            count++;
        }
        while (i <= mid) {
            temp[count] = nums[i];
            i++;
            count++;
        }
        while (j <= r) {
            temp[count] = nums[j];
            j++;
            count++;
        }
        // 把temp 放回nums 的对应位置
        int count2 = 0;
        for (int k = l; k <= r; k++) {
            nums[k] = temp[count2++];
        }
    }


    public void selectSort(int[] nums) {
        // 选择排序 O(n^2)
        for (int i = 0; i < nums.length; i++) {
            int curMinIndex = i;
            // 每次循环找出未排序部分最小值与当前未排序不分的第一位交换
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[curMinIndex]) {
                    curMinIndex = j;
                }
            }
            // 交换
            swap(nums, i, curMinIndex);
        }
    }

    public void insertSort(int[] nums) {
        // 插入排序
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            // 从i向前遍历,然后每遍历一位所有数向后移位
            int j = i;
            while (j > 0 && nums[j - 1] > cur) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = cur;
        }
    }

    public void bubbleSort(int[] nums) {
        // 冒泡排序
        // 从前往后两两交换,把大数交换到后面
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }


    private void swap(int[] nums, int i, int curMinIndex) {
        int t = nums[i];
        nums[i] = nums[curMinIndex];
        nums[curMinIndex] = t;
    }
}
