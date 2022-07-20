package com.hh.leetcode;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/7/20 9:34 下午
 */
public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix test = new SearchMatrix();
        System.out.println(test.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    /**
     * 1   3    7
     * 10  11   12
     * 24  24   25
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 以左下角为原点建立直角坐标系
        // 如果当前数大于目标数,向上
        // 如果当前数小于当前数,向右
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int num = matrix[row][col];
            if (num > target) {
                row--;
            } else if (num < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }
}
