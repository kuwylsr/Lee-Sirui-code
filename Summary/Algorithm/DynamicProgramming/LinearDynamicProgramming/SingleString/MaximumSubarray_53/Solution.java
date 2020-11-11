package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.MaximumSubarray_53;


public class Solution {

    // 动态规划:
    public int maxSubArray(int[] nums) {
        int max = nums[0]; 
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            // 或者写成
            // dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    // 动态规划 : 简化空间
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int pre = nums[0];
        int sum = 0;
        for(int i = 1; i < len; i++) {
            if(pre > 0){
                sum = pre + nums[i];
            }else{
                sum = nums[i];
            }
            pre = sum;
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }

    // 分治法: 线段树...
}
