package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.BestTimeToBuyAndSellStockII_122;

public class Solution {
    
    // 动态规划 : 
    // 时间复杂度 : O(N)
    // 空间复杂度 : O(N)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        //初始化
        dp[0][1] = 0-prices[0];
        dp[0][0] = 0;

        for(int i = 1 ; i< len ;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }   
        return dp[len-1][0]; 
    }

    // 动态规划 : 压缩空间
    // 时间复杂度 : O(N)
    // 空间复杂度 : O(1)
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        
        //初始化
        int tmp_stock = 0-prices[0]; //手里有股票
        int tmp_no_stock = 0; //手里没有股票
        
        for(int i = 1 ; i< len ;i++){
            tmp_no_stock = Math.max(tmp_no_stock, tmp_stock + prices[i]);
            tmp_stock = Math.max(tmp_stock, tmp_no_stock - prices[i]);
        }   
        return tmp_no_stock; 
    }
}
