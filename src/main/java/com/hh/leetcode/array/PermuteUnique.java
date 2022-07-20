package com.hh.leetcode.array;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author HaoHao
 * @date 2022/7/16 3:25 下午
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{1, 1, 2}));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();

        boolean[] used = new boolean[nums.length];

        // 排序让相等数挨着
        Arrays.sort(nums);

        dfs(nums, path, used, res);

        return res;
    }

    private void dfs(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 去重,当前数字数重复数字,且前一个是没有被用过的(防止 出现 11 11 位置互换)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;

            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }
}
