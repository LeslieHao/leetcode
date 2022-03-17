package com.hh.leetcode.primary.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author HaoHao
 * @date 2022/3/17 5:36 下午
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] res = new int[intervals.length][2];

        int resIndx = -1;
        for (int[] interval : intervals) {
            if (resIndx == -1 || interval[0] > res[resIndx][1]) {
                // 左值超过上个的右值,不合并
                resIndx++;
                res[resIndx] = interval;
            }else {
                // 合并
                res[resIndx][1] = Math.max(interval[1], res[resIndx][1]);
            }

        }
        return Arrays.copyOf(res, resIndx+1);

    }


}
