package DynamicProgramming.LinearDynamicProgramming.SingleString.HouseRobberII_213;

import java.util.Arrays;

public class Solution {

    // 动态规划: 两次(一次去掉首,一次去掉尾)
    public int myRob(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }

    public int rob(int[] nums){
        int len = nums.length;
        int[] nums1 = Arrays.copyOfRange(nums, 0, len-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,len);
        return Math.max(myRob(nums1),myRob(nums2));
    }


    // 个人解法: 错误XXXXXXXXXXXXX
    public int rob2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }else if (len == 1){
            return nums[0];
        }
        int[][] dp = new int[len][2];   
        dp[0][0] = nums[0];
        dp[0][1] = 1; // 盗窃第一间屋子,则为1 ,否则为0
        dp[0][0] = nums[1];
        dp[0][1] = 0; // 盗窃第一间屋子,则为1 ,否则为0

        int max = nums[0];
        for(int i = 1; i < len; i++){
            int tmp_max = 0;
            int flag = 1;
            for(int j = 1; j < i - 1; j++){
                if(dp[j][0] > tmp_max){
                    tmp_max = dp[j][0];
                    flag = dp[j][1];

                }
            }
            dp[i][0] = tmp_max + nums[i];
            dp[i][1] = flag;
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,2};
        int ans = solution.rob(nums);
        System.out.println(ans);
    }
}
