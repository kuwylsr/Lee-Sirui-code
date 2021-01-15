package Algorithm.DynamicProgramming.LinearDynamicProgramming.Matrix.MaximalSquare_221;

public class Solution {

    // 动态规划
    public int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        if(M == 0){
            return 0;
        }
        int N = matrix[0].length;
        int[][] dp = new int[M][N];

        
        //初始化(第一行和第一列)
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int maxLen = dp[0][0];
        for(int i = 1 ; i < M ; i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        for(int j = 1 ; j < N ; j++){
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxLen = Math.max(maxLen, dp[0][j]);
        }
        
        for(int i = 1 ; i < M ; i++){
            for(int j = 1 ; j < N ;j ++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
