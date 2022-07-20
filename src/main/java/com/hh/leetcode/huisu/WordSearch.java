package com.hh.leetcode.huisu;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/7/18 8:44 下午
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(test.exist(chars,"SEEa"));
    }

    int row;
    int co;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // 行
        row = board.length;
        // 列
        co = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < co; j++) {
                // 如果第一个字符不匹配,继续循环
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                // 每次从头开始,把visited 清空
                visited = new boolean[row][co];
                // 如果第一个字符匹配,开始搜索
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }

            }
        }

        return false;

    }

    int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * @param board
     * @param word
     * @param i
     * @param j
     * @param cur   当前匹配的字符长度
     * @return
     */
    private boolean dfs(char[][] board, String word, int i, int j, int cur) {
        if (cur == word.length()) {
            // 已经匹配了
            return true;
        }

        if (i < 0 || j < 0 || i >= row || j >= co) {
            // 越界
            return false;
        }

        // 如果当前字符已经visited
        if (visited[i][j]) {
            return false;
        }
        // 如果当前字符不相等
        if (board[i][j] != word.charAt(cur)) {
            return false;
        }

        // 匹配上了
        visited[i][j] = true;
        // 从当前点向上下左右四个方向匹配
        for (int[] dir : direct) {
            if (dfs(board, word, i + dir[0], j + dir[1], cur + 1)) {
                return true;
            }
        }
        // 没匹配成功,状态恢复
        visited[i][j] = false;
        return false;
    }

}
