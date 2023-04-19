package dynamic_programming;

/**
 * 416. 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1,1}));
    }

    public boolean canPartition(int[] nums) {

        if(nums.length == 1) {
            return false;
        }
        if(nums.length == 2){
            if(nums[0] == nums[1]){
                return true;
            }else{
                return false;
            }
        }

        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % 2 == 1){
            return false;
        }

        int[][] dp = new int[nums.length][(sum / 2) + 1];

        for (int i = 0; i < dp[0].length; i++){
            if (nums[0] <= i){
                dp[0][i] = nums[0];
            }
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){

                if (j == 0){
                    dp[i][0] = 0;
                    continue;
                }
                if (j == 1){
                    if (nums[i] <= j && nums[i] > dp[i-1][1]){
                        dp[i][1] = nums[i];
                    }else {
                        dp[i][1] = dp[i-1][1];
                    }
                    continue;
                }
                if (j - nums[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
                if (dp[i][j] == sum / 2){
                    return true;
                }
            }
        }

        return false;
    }
}
