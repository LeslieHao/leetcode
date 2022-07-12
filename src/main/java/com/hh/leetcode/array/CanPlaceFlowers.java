package com.hh.leetcode.array;

/**
 * 605. 种花问题
 * <p>
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 * @author HaoHao
 * @date 2022/2/15 5:22 下午
 */
public class CanPlaceFlowers {

    /**
     * 跳格子
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; ) {
            int cur = flowerbed[i];
            if (cur == 1) {
                // =1 向后跳两步
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                // =0,则此时前面一定是0
                // 只要后一个是0 或者当前是最后一位,可以种花
                count++;
                i += 2;
            } else {
                i += 3;
            }
            if (count == n || i > flowerbed.length) {
                break;
            }
        }
        return count == n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
