package com.hh.leetcode.dp;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * 通过次数212,321提交次数432,793
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/7/18 9:37 下午
 */
public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        // 最长边长
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 在左边或者上边
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }

        return maxSide * maxSide;
    }
}
