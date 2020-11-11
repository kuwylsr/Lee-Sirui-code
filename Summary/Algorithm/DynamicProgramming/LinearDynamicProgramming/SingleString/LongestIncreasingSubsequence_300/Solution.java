package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LongestIncreasingSubsequence_300;

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

    // 贪心 + 二分查找
    public int lengthOfLIS2(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
