package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.PaintHouse_256;

public class Solution {

    // 动态规划
    // 时间复杂度: O(N)
    // 空间复杂度 : O(1)
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];

        if(len == 0){
            return 0;
        }

        for(int k = 0 ; k < 3; k++){
            dp[0][k] = costs[0][k];
        }

        for(int i = 1 ; i < len ; i ++){
            for(int k = 0 ; k < 3 ; k++){
                int tmp_min = Integer.MAX_VALUE;
                for(int k1 = 0 ; k1 < 3 ; k1 ++){
                    if(k1 != k){
                        tmp_min = Math.min(tmp_min,dp[i-1][k1]);
                    }
                }
                dp[i][k] = tmp_min + costs[i][k];
            }
        }
        return Math.min(Math.min(dp[len-1][0],dp[len-1][1]),dp[len-1][2]);
    }
}
