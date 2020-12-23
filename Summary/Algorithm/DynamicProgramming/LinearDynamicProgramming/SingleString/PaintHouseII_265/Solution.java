package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.PaintHouseII_265;

public class Solution {

    // 动态规划 + 技巧
    public int minCostII(int[][] costs) {
        int len1 = costs.length;
        if(len1 == 0){
            return 0;
        }
        int len2 = costs[0].length;
        int[][] dp = new int[len1][len2];

        int tmp_min1 = Integer.MAX_VALUE;
        int tmp_min1_index = 0;
        int tmp_min2 = Integer.MAX_VALUE;
        int tmp_min2_index = 0;


        // 初始化第1间房间
        for(int k = 0 ; k < len2; k++){
            dp[0][k] = costs[0][k];
            if(dp[0][k] < tmp_min1){ // 找最小
                tmp_min1 = costs[0][k];
                tmp_min1_index = k;
            }
        }
        for(int k = 0 ; k < len2 ; k++){
            if(dp[0][k] < tmp_min2 && k != tmp_min1_index){ // 找次小
                tmp_min2 = costs[0][k];
                tmp_min2_index = k;
            }
        }

        for(int i = 1 ; i < len1; i++){
            for(int k = 0 ; k < len2 ;k++){
                if(tmp_min1_index != k){
                    dp[i][k] = dp[i-1][tmp_min1_index] + costs[i][k];
                }else{
                    dp[i][k] = dp[i-1][tmp_min2_index] + costs[i][k];
                }
            }
            // 更新当前的最小和次小
            tmp_min1 = Integer.MAX_VALUE;
            tmp_min2 = Integer.MAX_VALUE;
            tmp_min1_index = 0;
            tmp_min2_index = 0;
            for(int k = 0 ; k < len2; k++){
                if(dp[i][k] < tmp_min1){ // 找最小
                    tmp_min1 = dp[i][k];
                    tmp_min1_index = k;
                }
            }
            for(int k = 0 ; k < len2 ; k++){
                if(dp[i][k] < tmp_min2 && k != tmp_min1_index){ // 找次小
                    tmp_min2 = dp[i][k];
                    tmp_min2_index = k;
                }
            }
        }

        int res = dp[len1-1][0];
        for(int k = 0 ; k < len2 ;k++){
            res = Math.min(res, dp[len1-1][k]);
        }
        return res;
    }
}
