package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.NumberOfLongestIncreasingSubsequence_673;

import java.util.Arrays;

public class Solution {

    // 若用动态规划进行解题,则该题和 300 题一样
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        int[] count = new int[len];

        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxlen = 1;
        for(int i = 1; i < len ; i++){
            for(int j = 0 ; j < i ;j++){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i]){
                        count[i] = count[j];
                        dp[i] = dp[j] + 1;
                    }else if(dp[j]+1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxlen = Math.max(maxlen,dp[i]);
        }
        int result = 0;
        for(int i = 0 ; i < len ;i++){
            if(dp[i] == maxlen){
                result += count[i];
            }
        }
        return result;
    }

    // 线段树解题.....
}
