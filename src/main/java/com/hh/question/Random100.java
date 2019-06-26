package com.hh.question;

import java.util.Arrays;
import java.util.Random;

/**
 * 给定一个长度100 的数组
 * 要求不重复的放入1-100 的随机数
 * @author HaoHao
 * @date 2019-06-26 10:43
 */
public class Random100 {

    public static int[] random100(int arr[]) {
        // 有序放入
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 洗牌
        for (int i = 0; i < arr.length; i++) {
            // 生成0-99 的随机数
            Random random = new Random();
            int targetIndex = random.nextInt(arr.length - 1);
            // 交换当前位置到随机位置
            int temp = arr[i];
            arr[i] = arr[targetIndex];
            arr[targetIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        System.out.println(Arrays.toString(random100(arr)));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
