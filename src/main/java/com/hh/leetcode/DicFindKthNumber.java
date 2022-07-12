package com.hh.leetcode;

/**
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 *
 * 输入: n = 1, k = 1
 * 输出: 1
 *
 *
 * 提示:
 *
 * 1 <= k <= n <= 109
 *
 * @author HaoHao
 * @date 2022/7/10 10:31 下午
 */
public class DicFindKthNumber {


    public int findKthNumber(int n, int k) {
        // 十叉数的先序遍历

        int count = 0;

        int num = 1;
        while (true) {
            // 已经经过了k-1 个元素,到达了第k 个
            if (count == k - 1) {
                break;
            }

            int temp = count((long)num, n);
            if (count + temp >= k) {
                // 当前子树包含第k 个元素
                num *= 10;
                count++;
            }else {
                // 当前子树不包含第k 个元素,右移一个节点
                num++;
                count += temp;

            }
        }
        return num;
    }

    /**
     * 以num 为根节点的孩子个数
     */
    public int count(long num, int n) {
        int count = 0;
        // 当前层宽度
        int width = 1;
        while (true) {
            if (num + width - 1 <= n) {
                // 还没到第n 个
                count += width;
                num *= 10;
                width *= 10;
            } else {
                if (n - num >= 0) {
                    count += n - num + 1;
                }
                break;
            }
        }
        return count;
    }
}
