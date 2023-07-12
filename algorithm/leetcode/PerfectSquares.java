package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 * 1 <= n <= 104
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        int baseNum = 1;

        while (baseNum * baseNum <= n) {
            nums.add(baseNum * baseNum);
            baseNum++;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        //dp[j] 数j所需要的数最小数量 dp[j] = min(dp[j], dp[j - nums[i]] + 1)
        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i); j <= n; j++) {
                if (dp[j - nums.get(i)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - nums.get(i)] + 1);
                }
                System.out.print(dp[j] + "  ");
            }
            System.out.println();
        }

        return dp[n];
    }
}
