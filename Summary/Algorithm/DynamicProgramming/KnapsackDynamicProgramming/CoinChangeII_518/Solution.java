package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.CoinChangeII_518;

public class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        
        // 初始化
        dp[0] = 1; 

        // 完全背包, 组合问题
        for(int i = 0 ; i < len ; i++){
            int coin = coins[i];
            for(int j = 0 ; j <= amount ; j++){
                if(coin <= j){
                    dp[j] = dp[j] + dp[j-coin];
                }
            }
        }

        return dp[amount];
    }
}
