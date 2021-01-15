package Algorithm.DynamicProgramming.LinearDynamicProgramming.Matrix.DungeonGame_174;

public class Solution {

    // 动态规划 : "从后往前"
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        if(M == 0){
            return 0;
        }
        int N = dungeon[0].length;

        int[][] dp = new int[M][N];

        // 初始化(最后一行和最后一列)
        dp[M-1][N-1] = dungeon[M-1][N-1] > 0 ? 1 : 1 + Math.abs(dungeon[M-1][N-1]);
        for(int i = M-2 ; i >= 0 ;i--){
            dp[i][N-1] = Math.max(dp[i+1][N-1]-dungeon[i][N-1], 1);
        }
        for(int j = N-2 ; j >=0 ; j--){
            dp[M-1][j] = Math.max(dp[M-1][j+1]-dungeon[M-1][j], 1);
        }

        for(int i = M-2 ; i >= 0 ; i--){
            for(int j = N-2 ; j >=0 ; j--){
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
