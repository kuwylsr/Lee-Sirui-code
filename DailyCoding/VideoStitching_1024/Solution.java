package VideoStitching_1024;

import java.util.Arrays;

class Solution {
    // 官方题解: 动态规划
    public int videoStitching(int[][] clips, int T) {
        int dp[] = new int[T+1];
        
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1 ; i <= T ;i ++){
            for(int[] clip : clips){
                if(i > clip[0] && i <= clip[1]){
                    int aj = clip[0];
                    dp[i] = Math.min(dp[aj] + 1,dp[i]);
                }
            }
        }
        return (dp[T] == Integer.MAX_VALUE - 1) ? -1 : dp[T];
    }


    // 官方题解2: 贪心算法
    public int videoStitching2(int[][] clips, int T) {
        
        return 0;
    }
}
