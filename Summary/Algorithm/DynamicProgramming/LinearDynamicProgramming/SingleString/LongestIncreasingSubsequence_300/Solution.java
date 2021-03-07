package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LongestIncreasingSubsequence_300;

import java.util.Arrays;

public class Solution {

    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int len = nums.length;
        if(len == 0 ){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        
        for(int i = 1; i < len; i++){
            int tmp_max = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] > tmp_max){
                        tmp_max = dp[j];
                    }
                }
            }
            if(tmp_max == Integer.MIN_VALUE){
                dp[i] = 1;
            }else{
                dp[i] = tmp_max + 1;
            }

            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    // 比上面的简洁一些
    public int lengthOfLIS2(int[] nums) {

        int len = nums.length;

        int[] dp = new int[len];
        Arrays.fill(dp,1);

        int maxlen = 1;
        for(int i = 1 ; i < len ;i++){
            for(int j = 0 ; j < i ;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxlen = Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }

    // 贪心 + 二分查找
    public int lengthOfLIS3(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
