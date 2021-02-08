package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.CombinationSumIV_377;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];

        // 初始化
        dp[0] = 1;
        
        // 求排序(考虑顺序)(完全背包)
        for(int j = 1 ; j <= target ; j++){
            for(int i = 0 ; i < len ; i++){
                if(nums[i] <= j){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
