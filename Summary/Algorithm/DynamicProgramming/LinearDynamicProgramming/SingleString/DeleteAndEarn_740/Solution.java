package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.DeleteAndEarn_740;

import java.util.Arrays;

public class Solution {
    
    // 动态规划 : 官方题解
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }else if(len == 1){
            return nums[0];
        }

        int max = nums[0];
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        int[] all = new int[max + 1];
        Arrays.fill(all, 0);
        for(int num : nums){
            all[num] ++;
        }

        int[] dp = new int[max+1];
        dp[1] = 1 * all[1];
        dp[2] = Math.max(2 * all[2], dp[1]);

        for(int i = 3 ; i <= max; i++){
            dp[i] = Math.max(dp[i-2] + i * all[i], dp[i-1]);
        }

        return dp[max];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 3, 3, 4};
        int ans = solution.deleteAndEarn(nums);
        System.out.println(ans);
    }
}
