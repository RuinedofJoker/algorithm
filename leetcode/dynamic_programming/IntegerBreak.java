package dynamic_programming;

/**
 * 343. 整数拆分
 * 提示
 * 中等
 * 1.2K
 * 相关企业
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 提示:
 * 2 <= n <= 58
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        if (n < 4){
            return n - 1;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i < dp.length; i++){

            int splitTwo = i / 2 * (i - (i / 2));
            int splitOther = 0;

            for (int j = 1; j < i; j++){
                int currSplitOther = (i - j) * dp[j];
                splitOther = Math.max(currSplitOther, splitOther);
            }

            dp[i] = Math.max(splitTwo, splitOther);
        }

        return dp[dp.length-1];
    }
}
