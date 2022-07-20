package com.hh.leetcode.dp;

/**
 * 圆环回原点
 * <p>
 * <p>
 * 圆环上有 10 个点，编号 0~9 。从 0 出发，每次可以顺时针或逆时针走一格，请问一共走且仅走 n 步回到原点的方法有多少种。
 * <p>
 * 输入
 * 2
 * 输出
 * 2
 * 说明
 * 可能的方案有 0->1->0， 0->9->0
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/16409dd00ab24a408ddd0c46e49ddcf8?answerType=1&f=discussion
 * 来源：牛客网
 *
 * @author HaoHao
 * @date 2022/7/17 9:16 下午
 */
public class CycleToZero {

    public static void main(String[] args) {
        CycleToZero cycleToZero = new CycleToZero();
        System.out.println(cycleToZero.solution(2));
    }

    /**
     * dp[i][j] 表示走i 步到 j 点有多少种走法
     * dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1]
     * @param n
     * @return
     */
    public int solution(int n) {

        int mod = 1000000007;

        int[][] dp = new int[n + 1][10];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = (dp[i - 1][(j - 1 + 10) % 10] + dp[i - 1][(j + 1) % 10]) % mod;
            }

        }
        // 走n 到0
        return dp[n][0];
    }
}
