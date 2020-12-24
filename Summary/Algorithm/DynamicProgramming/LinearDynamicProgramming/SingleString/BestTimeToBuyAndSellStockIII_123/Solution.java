package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.BestTimeToBuyAndSellStockIII_123;

public class Solution {

    // 动态规划 : 
    // 时间复杂度 : O(N)
    // 空间复杂度 : O(N)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int [][][] dp = new int[len][2][2];

        // 初始化
        dp[0][0][1] = 0-prices[0];
        dp[0][0][0] = 0;
        dp[0][1][1] = 0-prices[0];
        dp[0][1][0] = 0;

        for(int i = 1; i < len ;i ++){
            dp[i][0][1] = Math.max(dp[i-1][0][1], 0-prices[i]);
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][0][1]+prices[i]);
            
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0]-prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1]+prices[i]);
        }
        return dp[len-1][1][0];
    }

    // 动态规划 : 简化空间
    // 时间复杂度 : O(N)
    // 空间复杂度 : O(1)
    public int maxProfit2(int[] prices){
        int len = prices.length;

        // 定义变量,并初始化
        int oneday_stock = 0-prices[0]; //第一次炒股,手里有股票
        int oneday_no_stock = 0; //第一次炒股,手里没有股票
        int twoday_stock = 0-prices[0]; //第二次炒股,手里有股票
        int twoday_no_stock = 0; //第二次炒股,手里没有股票

        for(int i = 1 ; i < len ; i++){
            oneday_stock = Math.max(oneday_stock,0- prices[i]);
            oneday_no_stock = Math.max(oneday_no_stock,oneday_stock+prices[i]);

            twoday_stock = Math.max(twoday_stock, oneday_no_stock- prices[i]);
            twoday_no_stock = Math.max(twoday_no_stock,twoday_stock+ prices[i]);
        }
        return twoday_no_stock;
    }
}
