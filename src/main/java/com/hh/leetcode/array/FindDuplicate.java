package com.hh.leetcode.array;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * @author HaoHao
 * @date 2022/7/19 10:28 下午
 */
public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate test = new FindDuplicate();
        System.out.println(test.findDuplicate(new int[]{1, 2, 3, 4, 2, 2}));
    }

    /**
     * 0->1
     * 1->3
     * 2->4
     * 3->2
     * 4->2
     *
     * 0-1-3-2-4-2
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 构造环形链表
        int fast = 0;
        int slow = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 相遇之后
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
