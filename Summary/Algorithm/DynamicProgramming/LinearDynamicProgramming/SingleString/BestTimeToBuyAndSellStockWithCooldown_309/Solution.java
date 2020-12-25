package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.BestTimeToBuyAndSellStockWithCooldown_309;

public class Solution {

    // 动态规划 : (不好理解)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][3];

        if (len == 0){
            return 0;
        }

        //初始化
        dp[0][0] = 0;
        dp[0][2] = 0-prices[0];

        for(int i = 1 ; i < len ; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]+prices[i]);
            dp[i][1] = dp[i-1][0];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

    // 动态规划 : (容易理解)
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][3];

        if (len == 0){
            return 0;
        }

        //初始化
        dp[0][0] = 0;
        dp[0][1] = 0; // 这种情况其实是不存在的, 但初始化为0没有问题.
        dp[0][2] = 0-prices[0];

        for(int i = 1 ; i < len ; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][2] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] - prices[i]);
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

}
