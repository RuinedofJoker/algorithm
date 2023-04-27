package leetcode.greedy_algorithm;

/**
 * 53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {

        int result = nums[0];
        boolean isAllNeg = true;
        int maxNeg = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                isAllNeg = false;
            }
            maxNeg = Math.max(maxNeg, nums[i]);
            if (sum + nums[i] > 0){
                sum += nums[i];
                result = Math.max(result, sum);
            }else {
                sum = 0;
            }
        }

        if (isAllNeg){
            return maxNeg;
        }else {
            return result;
        }
    }
}
