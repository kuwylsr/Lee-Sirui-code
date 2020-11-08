package DynamicProgramming.LinearDynamicProgramming.SingleString.HouseRobber_198;

public class Solution {

    // 动态规划1: 个人解法
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];   
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < len; i++){
            int tmp_max = 0;
            for(int j = 0 ; j < i - 1; j++){
                if(dp[j] > tmp_max){
                    tmp_max = dp[j];
                }
            }
            dp[i] = tmp_max + nums[i];
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    // 动态规划2 : 参考答案
    public int rob2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }else if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] nums = {2,7,9,3,1};
        int ans = S.rob2(nums);
        System.out.println(ans);
    }
}
