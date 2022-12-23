package cn.lettcode.study.LT_1_删除排序数组中的重复项;

import java.util.Arrays;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：<a href="https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/">删除排序数组中的重复项</a>
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        int i = solution.removeDuplicates(nums);
        System.out.println("i = " + i);
        System.out.println("nums = " + Arrays.toString(nums));
    }

}

class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int x = 0, y = 1;
        while (++x < nums.length) {
            if (nums[x - 1] < nums[x]) {
                nums[y++] = nums[x];
            }
        }
        return y;

    }
}