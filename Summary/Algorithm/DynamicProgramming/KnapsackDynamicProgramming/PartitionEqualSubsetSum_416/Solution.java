package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.PartitionEqualSubsetSum_416;

public class Solution {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int[] dp = new int[(int)(sum/2)+1];

        for(int i = 0 ; i < len ;i++){
            int num = nums[i];
            for(int j = (int)(sum/2) ; j >= 0 ;j--){
                if(num <= j){
                    dp[j] = Math.max(dp[j], dp[j-num] + num);
                }
            }
        }
        return dp[(int)(sum/2)]*2 == sum ;
    }

    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum %2 == 1){ //sum为奇数返回false
            return false;
        }

        boolean[] dp = new boolean[(int)(sum/2)+1];
        dp[0] = true;

        for(int i = 0 ; i < len ;i++){
            int num = nums[i];
            for(int j = (int)(sum/2) ; j > 0 ;j--){
                if(num <= j){
                    dp[j] = dp[j] || dp[j-num];
                }
            }
        }
        return dp[(int)(sum/2)];
    }
}
