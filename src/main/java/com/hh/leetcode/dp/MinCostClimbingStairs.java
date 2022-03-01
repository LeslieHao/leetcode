package com.hh.leetcode.dp;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 * @author HaoHao
 * @date 2022/2/15 3:00 下午
 */
public class MinCostClimbingStairs {

    /**
     * 局部最优到全局最优。假如要到达某一层，只要考虑两件事：是从楼下走1层上来，还是从楼下的楼下跨2层上来。
     * 所以就有了 dp[i] = min(dp[i-1]+down, dp[i-2]+downdown)
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int down = 0;
        int downdown = 0;
        for (int i = 2; i <=n; i++) {
            // 到当前楼层的最小消耗
            int cur = Math.min(cost[i - 1] + down, cost[i - 2] + downdown);
            downdown = down;
            down = cur;
        }
        return down;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
