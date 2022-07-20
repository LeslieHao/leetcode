package com.hh.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 * 通过次数549,791提交次数756,383
 *
 * @author HaoHao
 * @date 2022/7/15 9:11 下午
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 回溯
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, 0, target, new ArrayDeque<>(), res);

        return res;
    }

    /**
     * @param candidates 目标数组
     * @param begin      当前开始下标
     * @param target     目标值
     * @param path       当前路径
     * @param res        返回结果
     */
    private void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            // 无效路径
            return;
        }
        if (target == 0) {
            // 有效路径
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 当前节点加入path
            path.addLast(candidates[i]);
            // 继续dfs
            dfs(candidates, i, target - candidates[i], path, res);
            // 状态恢复
            path.removeLast();
        }
    }
}
