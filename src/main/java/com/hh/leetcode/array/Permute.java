package com.hh.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @author HaoHao
 * @date 2022/7/11 10:15 下午
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            out.add(nums[i]);
        }
        dfs(nums.length, out, res, 0);

        return res;

    }

    private void dfs(int length, List<Integer> out, List<List<Integer>> res, int first) {
        if (first == length) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = first; i < length; i++) {
            Collections.swap(out, first, i);
            dfs(length, out, res, first + 1);
            Collections.swap(out, first, i);
        }
    }

}
