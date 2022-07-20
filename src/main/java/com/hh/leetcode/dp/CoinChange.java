package com.hh.leetcode.dp;

/**
 * 322. 零钱兑换
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @author HaoHao
 * @date 2022/3/10 7:31 下午
 */
public class CoinChange {




    int res = Integer.MAX_VALUE;

    public  int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        // 递归
        find(coins, amount, 0);

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }

    private  void find(int[] coins, int amount, int n) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(n, res);
        }
        for (int i = 0; i < coins.length; i++) {
            find(coins, amount - coins[i], n + 1);
        }
    }

    public  void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
