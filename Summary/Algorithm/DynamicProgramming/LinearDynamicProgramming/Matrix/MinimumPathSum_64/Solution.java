package Algorithm.DynamicProgramming.LinearDynamicProgramming.Matrix.MinimumPathSum_64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int len1 = grid.length;
        if(len1 == 0){
            return 0;
        }
        int len2 = grid[0].length;
        int[][] dp = new int[len1][len2];

        // 初始化
        dp[0][0] = grid[0][0];
        for(int i = 1 ; i < len1 ; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1 ; j < len2 ; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i = 1 ; i < len1 ; i++){
            for(int j = 1 ; j < len2 ; j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[len1-1][len2-1];
    }
}
