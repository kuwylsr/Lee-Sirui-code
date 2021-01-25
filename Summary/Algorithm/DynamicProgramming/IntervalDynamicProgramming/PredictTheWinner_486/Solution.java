package Algorithm.DynamicProgramming.IntervalDynamicProgramming.PredictTheWinner_486;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int nums_len = nums.length;
        int[][] dp = new int[nums_len][nums_len];

        int sum = 0;
        // 初始化(len为1和2)
        for(int i = 0 ; i < nums_len ; i++){
            dp[i][i] = nums[i];
            sum += nums[i]; //统计总分数
        }
        for(int i = 0 ; i < nums_len - 1; i++){
            dp[i][i+1] = Math.max(nums[i],nums[i+1]);
        }

        for(int len = 3 ; len <= nums_len ;len++){
            for(int i = 0 ; i <= nums_len - len ; i++){
                int j = len + i - 1;
                int tmp_score1 = nums[i] + Math.min(dp[i+1][j-1],dp[i+2][j]);
                int tmp_score2 = nums[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                dp[i][j] = Math.max(tmp_score1,tmp_score2);
            }
        }
        return dp[0][nums_len-1]*2 >= sum ? true : false;
    }
}
