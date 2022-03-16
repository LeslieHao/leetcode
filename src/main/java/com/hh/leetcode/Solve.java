package com.hh.leetcode;

/**
 * NC112 进制转换
 *
 * 描述
 * 给定一个十进制数 M ，以及需要转换的进制数 N 。将十进制数 M 转化为 N 进制数。
 *
 * 当 N 大于 10 以后， 应在结果中使用大写字母表示大于 10 的一位，如 'A' 表示此位为 10 ， 'B' 表示此位为 11 。
 *
 * 若 M 为负数，应在结果中保留负号。
 *
 * 数据范围： M <= 10^8 , 2 \le N \le 16M<=10
 * 8
 *  ,2≤N≤16
 * 要求：空间复杂度O(M)O(M)，时间复杂度 O(M)O(M)
 * 示例1
 * 输入：
 * 7,2
 * 返回值：
 * "111"
 * 示例2
 * 输入：
 * 10,16
 * 返回值：
 * "A"
 *
 * @author HaoHao
 * @date 2022/3/16 4:25 下午
 */
public class Solve {

    public String solve(int M, int N) {
        // write code here
        String set  ="0123456789ABCDEF";
        if(M == 0){
            return "0";
        }

        boolean flag = false;
        if(M<0){
            M=-M;
            flag =true;
        }
        StringBuilder sb = new StringBuilder();
        while(M!=0){
            sb.append(set.charAt(M%N));
            M = M/N;
        }
        if(flag){
            sb.append("-");
        }
        return sb.reverse().toString();

    }
}
