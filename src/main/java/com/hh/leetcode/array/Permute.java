package com.hh.leetcode.array;

import java.util.*;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
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
        System.out.println(permute.permute1(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute1(int[] nums) {
        // 回溯
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        dfs1(nums, 0, new ArrayDeque<>(), used, res);
        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param nums  数组
     * @param depth 当前遍历第几层
     * @param path  当前遍历路径
     * @param used  数组中每个元素的使用情况
     * @param res   返回结果
     */
    public void dfs1(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            // 遍历到最后一层结束
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 找到第一个未被使用的元素
            // 添加到path
            path.addLast(nums[i]);
            // 标记为已使用
            used[i] = true;
            // 继续遍历下一层
            dfs1(nums, depth + 1, path, used, res);
            // 回到上一层,状态恢复
            path.removeLast();
            used[i] = false;
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        // 回溯
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        for (int num : nums) {
            out.add(num);
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
