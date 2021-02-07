package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.CoinChange_322;

import java.util.Arrays;

public class Solution {

    // 动态规划
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len][amount+1];
        if(amount == 0){
            return 0;
        }
        // 初始化(第0行)
        dp[0][0] = 0;
        for(int j = 1; j <= amount ; j++){
            if(coins[0] > j || dp[0][j-coins[0]] == -1){
                dp[0][j] = -1;
            }else{
                dp[0][j] = dp[0][j-coins[0]] + 1;
            }
        }

        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j <= amount ;j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    if(dp[i][j-coins[i]] == -1){
                        dp[i][j] = dp[i-1][j];
                    }else if(dp[i-1][j] == -1){
                        dp[i][j] = dp[i][j-coins[i]] + 1;
                    }else{
                        dp[i][j] = Math.min(dp[i][j-coins[i]]+1, dp[i-1][j]);
                    }
                }
            }
        }
        return dp[len-1][amount];
    }

    //动态规划(优化空间)(推荐使用!!! 注意模板)
    public int coinChange2(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);

        // 初始化
        dp[0] = 0; //由于使用了amount + 1进行填充, 因此需要初始化j==0

        for(int i = 0 ; i < len ; i++){
            for(int j = 1 ; j <= amount ; j++){
                if(coins[i] <= j){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 动态规划(官方题解)
    public int coinChange3(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);

        // 初始化
        dp[0] = 0; //由于使用了amount + 1进行填充, 因此需要初始化j==0

        for(int j = 1 ; j <= amount ; j++){
            for(int i = 0 ; i < len ; i++){
                if(coins[i] <= j){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 如果变为不能重复选取(01背包问题)
    public int coinChange_01(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);

        // 初始化
        dp[0] = 0; //由于使用了amount + 1进行填充, 因此需要初始化j==0

        for(int i = 0 ; i < len ; i++){
            for(int j = amount ; j > 0 ; j--){
                if(coins[i] <= j){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] coins = {1,4,10,3,7};
        int amount = 25;
        int res1 = solution.coinChange(coins, amount);
        int res2 = solution.coinChange_01(coins, amount);
        System.out.println(res1);
        System.out.println(res2);
    }
}
