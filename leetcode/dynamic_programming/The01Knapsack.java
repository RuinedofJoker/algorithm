package dynamic_programming;

/**
 * 01背包
 */
public class The01Knapsack {

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[value.length][bagSize+1];

        for (int i = 0; i < dp[0].length; i++){
            if (i >= weight[0]){
                dp[0][i] = value[0];
            }
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (j == 0){
                    continue;
                }

                if (j == 1){
                    if (value[i] > dp[i-1][1] && weight[i] <= 1){
                        dp[i][1] = value[i];
                    }else {
                        dp[i][1] = dp[i-1][1];
                    }
                    continue;
                }

                if (j - weight[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println();
    }
}
