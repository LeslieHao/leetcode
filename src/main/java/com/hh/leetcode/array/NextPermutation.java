package com.hh.leetcode.array;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/7/13 11:41 下午
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation test = new NextPermutation();
        int[] arr = {1};
        test.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 从后往前找到第一个下降的数,下表为 s(较小的数)
        int s = -1;
        for (int i = nums.length - 2; i < nums.length; i--) {
            if (nums[i] < nums[i + 1]) {
                s = i;
                break;
            }
            if (i == 0) {
                break;
            }
        }


        int m = -1;
        // 如果s <0,则当前位 321 这种最大序列,下一个排列 就是直接反转
        if (s >= 0) {
            // 从后到s,找到第一个大于num[s]的数,下标为 m(较大的数)
            for (int i = nums.length - 1; i < nums.length; i--) {
                if (nums[i] > nums[s]) {
                    m = i;
                    break;
                }
            }
            // 交换
            int temp = nums[s];
            nums[s] = nums[m];
            nums[m] = temp;
        }


        // 反转k 往后的部分
        int r = nums.length - 1;
        int l = s + 1;
        while (l < r) {
            // 交换
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }

    }
}
