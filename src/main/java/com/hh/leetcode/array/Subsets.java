package com.hh.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author HaoHao
 * @date 2022/7/11 11:50 下午
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> res2 = subsets.subsets2(new int[]{1, 2, 3});
        System.out.println(res2);
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            // 按长度dfs
            dfs2(nums, 0, i, path, res);
        }
        return res;
    }

    private void dfs2(int[] nums, int start, int len, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs2(nums, i + 1, len, path, res);
            path.removeLast();
        }
    }


    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
