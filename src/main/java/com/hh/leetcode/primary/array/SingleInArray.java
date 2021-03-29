package com.hh.leetcode.primary.array;

/**
 * 数组中都成对相连出现
 * 只有一个不成对
 * 求此数对应的下标
 * <p>
 * [1,1,2,2,3,3,4,5,5]
 *
 * @author HaoHao
 * @date 2021/3/29 3:53 下午
 */
public class SingleInArray {


    public static int getSingleIndex(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length || (arr[i] ^ arr[i + 1]) != 0) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    public static int getSingleIndexLogn(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        // 中心点
        int index = arr.length / 2;
        // 中心点刚好是single
        if (arr[index] != arr[index + 1] && arr[index] != arr[index - 1]) {
            return index;
        }
        // 一半 可能是奇数也可能是偶数
        int half = arr.length / 2;
        // 一半是否是奇数
        boolean isHalfAdd = (half % 2 == 1);

        if (arr[index] == arr[index + 1]) {
            // 和右边相等
            if (isHalfAdd) {
                // 如果一半是奇数,则在左面
                return getSingleIndex(arr, 0, index - 1);
            } else {
                // 在右边
                return getSingleIndex(arr, index + 2, arr.length);
            }
        } else {
            // 和左边相等
            if (isHalfAdd) {
                // 如果一半是奇数,在右边
                return getSingleIndex(arr, index + 1, arr.length);
            } else {
                // 在左面
                return getSingleIndex(arr, 0, index - 2);
            }
        }
    }


    public static int getSingleIndex(int[] arr, int start, int end) {
        if (start + 1 == end) {
            return start == 0 ? start : end - 1;
        }
        for (int i = start; i < end; i += 2) {
            if (i + 1 == arr.length) {
                return i;
            }
            if (arr[i] != arr[i + 1]) {
                return i;
            }
        }
        return end;
    }


    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 2, 2, 6, 7, 7};
        System.out.println(getSingleIndexLogn(arr));
    }
}
