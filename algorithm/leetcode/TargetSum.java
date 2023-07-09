package leetcode;

/**
 * 494. 目标和
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
    public int findTargetSumWays(int[] nums, int target) {
        int allSum = 0;
        for (int i : nums) {
            allSum += i;
        }

        //positive + negative = allSum
        //positive - negative = target
        //positive = (allSum + target) / 2

        if ((allSum + target) % 2 != 0) return 0;
        if (target < 0 && allSum < -target) return 0;

        int size = Math.abs((allSum + target) / 2);
        int[] dp = new int[size + 1];

        //dp[j]表示得到数字j的组合方式有dp[j]种
        //初始化
        dp[0] = 1;

        //dp[j] = dp[j] + dp[j - num[i]] (j - num[i] >= 0)
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[dp.length - 1];
    }
}
