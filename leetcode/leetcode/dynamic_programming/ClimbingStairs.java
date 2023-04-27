package leetcode.dynamic_programming;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2){
            return n;
        }

        int[] dpClimbStairs = new int[n+1];
        dpClimbStairs[0] = 0;
        dpClimbStairs[1] = 1;
        dpClimbStairs[2] = 2;

        for (int i = 3; i < dpClimbStairs.length; i++){
            dpClimbStairs[i] = dpClimbStairs[i-1] + dpClimbStairs[i-2];
        }

        return dpClimbStairs[dpClimbStairs.length - 1];
    }
}
