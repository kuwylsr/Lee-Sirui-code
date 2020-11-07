package DynamicProgramming.LinearDynamicProgramming.SingleString.MaximumProductSubarray_152;

public class Solution {

    // 动态规划: 
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        // 二维数组的第一列为fmax, 第二列为fmin
        int[][] dp = new int[len][2];
        int max = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        
        for(int i = 1; i < len; i++){
            if(nums[i] >= 0){
                dp[i][0] = Math.max(nums[i], nums[i] * dp[i-1][0]);
                dp[i][1] = Math.min(nums[i], nums[i] * dp[i-1][1]);
            }else{
                dp[i][0] = Math.max(nums[i], nums[i] * dp[i-1][1]);
                dp[i][1] = Math.min(nums[i], nums[i] * dp[i-1][0]);
            }
            // 或者写成
            // dp[i][0] = Math.max(dp[i-1][0] * nums[i], Math.max(dp[i-1][1] * nums[i], nums[i]));
            // dp[i][1] = Math.min(dp[i-1][0] * nums[i], Math.min(dp[i-1][1] * nums[i], nums[i]));
            max = Math.max(max,dp[i][0]);
        }
        return max;
    }

    // 动态规划 : 简化空间
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int max = nums[0];
        int pre_max = nums[0];
        int pre_min = nums[0];
        int muli_max = nums[0];
        int muli_min = nums[0];
        
        for(int i = 1 ; i < len; i++){
            if(nums[i] >= 0){
                muli_max = Math.max(nums[i], nums[i] * pre_max);
                muli_min = Math.min(nums[i], nums[i] * pre_min);
            }else{
                muli_max = Math.max(nums[i], nums[i] * pre_min);
                muli_min = Math.min(nums[i], nums[i] * pre_max);
            }
            max = Math.max(max, muli_max);
            pre_max = muli_max;
            pre_min = muli_min;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] nums = {2,3,-2,4};
        int ans = S.maxProduct(nums);
        System.out.println(ans);
    }
}
