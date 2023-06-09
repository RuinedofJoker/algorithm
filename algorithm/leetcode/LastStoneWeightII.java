package leetcode;

/**
 * 1049. 最后一块石头的重量 II
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 *
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 *
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        System.out.println(new LastStoneWeightII().lastStoneWeightII(new int[]{31,26,33,21,40}));
    }

    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1){
            return stones[0];
        }
        if (stones.length == 2){
            return Math.abs(stones[0] - stones[1]);
        }

        int sum = 0;
        for (int i : stones){
            sum += i;
        }

        int[][] dp = new int[stones.length][(sum / 2)+1];

        for (int i = 0; i < dp[0].length; i++){
            if (stones[0] <= i){
                dp[0][i] = stones[0];
            }
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (j == 1){
                    if (stones[i] > dp[i-1][j] && stones[i] <= j){
                        dp[i][1] = stones[i];
                    }else {
                        dp[i][1] = dp[i-1][1];
                    }
                    continue;
                }

                if (j - stones[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]] + stones[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int left = sum - dp[dp.length-1][dp[0].length-1];
        int right = sum - left;
        return Math.abs(left - right);
    }
}
