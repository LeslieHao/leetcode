package com.hh.leetcode.array;

import java.util.*;

/**
 * 给定两个数组nums1和nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/28 2:56 下午
 */
public class Intersect2 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 排序+双指针
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> res = new HashSet<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else if (nums1[i1] == nums2[i2]) {
                res.add(nums1[i1]);
                i1++;
                i2++;
            }
        }

        return res.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{12, 3, 4, 5, 5}, new int[]{5, 5, 2, 3})));
    }


}
