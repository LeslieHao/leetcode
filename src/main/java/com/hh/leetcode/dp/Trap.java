package com.hh.leetcode.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author HaoHao
 * @date 2022/3/16 4:08 下午
 */
public class Trap {

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int water = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 当前柱子比栈顶的高,形成低洼,且每次只把低洼处pop
                Integer bottom = stack.pop();
                if (stack.isEmpty()) {
                    // 没有左墙 白搭
                    break;
                }
                int leftWall = stack.peek();
                int leftHeight = height[leftWall];
                int rightHeight = height[i];
                int bottomHeight = height[bottom];
                // 能积攒的水=(右墙位置-左墙位置-1) * (min(右墙高度, 左墙高度)-低洼处高度)
                water += (i - leftWall - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);

            }

            stack.push(i);
        }
        return water;
    }

    public long maxWater(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        int water = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int right = 0; right < arr.length; right++) {
            while (!stack.isEmpty() && arr[right] > arr[stack.peek()]) {
                // 低洼处
                Integer bottom = stack.pop();
                if (stack.isEmpty()) {
                    // 前面没有墙了
                    break;
                }
                int left = stack.peek();
                int leftHeight = arr[left];
                int rightHeight = arr[right];
                int bottomHeight = arr[bottom];
                water += (right - left - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);
            }

            stack.push(right);

        }
        return water;

    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));

    }
}
