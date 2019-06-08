package com.hh.leetcode.primary.array;

/**
 * @author HaoHao
 * @Description:给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * @date 2018/7/21下午5:50
 */
public class MaxProfit {

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 7解释: 在第 2 天（股票价格 = 1）的时候买入，
     * 在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * @param prices 股票价格
     * @return
     */

    public static int maxProfit(int[] prices) {
        // 当出现比买入值大的 且后一天比当前小的 卖出

        if (prices.length == 0)
            return 0;

        int money = 0;

        int priceIn = 0;

        boolean buyFlag = false;

        for (int i = 0; i < prices.length - 1; i++) {
            if (!buyFlag) {
                // 如果当前价格前后的都小 买入
                if (prices[i] < prices[i + 1]) {
                    priceIn = prices[i];
                    buyFlag = true;
                }
            } else {
                // 准备卖出
                if ((prices[i] > priceIn && prices[i + 1] <= prices[i])) {

                    money += (prices[i] - priceIn);
                    buyFlag = false;
                }


            }
            if (buyFlag && i + 2 == prices.length) {
                // 已经到了最后一天 还没跌
                money += (prices[i + 1] - priceIn);
                return money;
            }
        }

        return money;
    }


}
