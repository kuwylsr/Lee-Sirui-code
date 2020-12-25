package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.BestTimeToBuyAndSellStockIV_188;

public class Solution {

    // 个人解法 : 动态规划错误(问题在problem)
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][k][2];

        //初始化
        for(int i = 0 ; i< len ;i++){
            dp[i][0][1] = 0-prices[i];
            //-------------------------------
            // 第一次炒股在第i天交易后, 手中没有股票的最大利润不好求.
            dp[i][0][0] = 0; //problem
            //-------------------------------
        }
        
        for(int x = 0 ; x < k ;x++){
            dp[0][x][1] = 0-prices[0];
            dp[0][x][0] = 0;
        }

        for(int i = 1 ; i < len ;i++){
            for(int x = 1; x < k ;x++){
                dp[i][x][1] = Math.max(dp[i-1][x][1], dp[i-1][x-1][0] - prices[i]);
                dp[i][x][0] = Math.max(dp[i-1][x][0], dp[i-1][x][1] + prices[i]);
            }
        }
        return dp[len-1][k-1][0];
    }

    // 动态规划:
    public int maxProfit2(int k, int[] prices) {
        int len = prices.length;

        // k增加一维,来避免从k==0开始遍历, 使得k-1越界
        // 为什么不初始化k==0, 然后从k==1开始遍历 ?
        // 因为k==0时初始化起来比较困难(遍历所有i)
        // 这也导致了第一种方法的错误, 第一种方法初始化k==0是有问题的.
        int[][][] dp = new int[len][k+1][2]; 

        if(len == 0){
            return 0;
        }

        //初始化
        for(int x = 1; x <=k ;x++){
            dp[0][x][1] = 0-prices[0];
            dp[0][x][0] = 0;
        }

        for(int i = 1 ; i< len ;i++){
            for(int x = 1 ; x <= k ;x++){
                dp[i][x][1] = Math.max(dp[i-1][x][1], dp[i-1][x-1][0] - prices[i]);
                dp[i][x][0] = Math.max(dp[i-1][x][0], dp[i-1][x][1] + prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
