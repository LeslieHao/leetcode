package com.hh.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author HaoHao
 * @date 2022/1/17 9:07 下午
 */
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> res = new HashSet<>();

        for (int i = 1; i <= nums.length; i++) {
            res.add(i);
        }
        for (int num : nums) {
            res.remove(num);
        }
        return new ArrayList<>(res);
    }


    /**
     * 注意到nums 的长度恰好也为 n，能否让 nums 充当哈希表呢？
     * <p>
     * 由于 nums 的数字范围均在 [1,n]中，我们可以利用这一范围之外的数字，来表达「是否存在」的含义。
     * <p>
     * 具体来说，遍历 nums，每遇到一个数 x，就让 nums[x−1] 增加 n。由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于 n。
     * <p>
     * 最后我们遍历 nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1。这样我们就找到了缺失的数字。
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        // 下标记录出现过的数字
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers1(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
