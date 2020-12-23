package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.BestTimeToBuyAndSellStock_121;

public class Solution {

    // 暴力搜索 
    // 时间复杂度 : O(N^2)
    // 空间复杂度 : O(1)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;

        for(int i = 0; i < len ; i++){
            for(int j = i+1 ; j < len ;j ++){
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    // 一次遍历 :
    // 时间复杂度 : O(N)
    // 空间复杂度 : O(1)
    public int maxProfit2(int[] prices){
        int len = prices.length;
        int max = 0;
        int history_min = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++){
            if(prices[i] < history_min){
                history_min = prices[i];
            }
            if(prices[i] - history_min > max){
                max = prices[i] - history_min;
            }
        }
        return max;
    }
}
