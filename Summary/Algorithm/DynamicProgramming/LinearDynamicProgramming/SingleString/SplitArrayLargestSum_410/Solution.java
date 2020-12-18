package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.SplitArrayLargestSum_410;

import java.util.Arrays;

public class Solution {


    // 个人解法 : 动态规划
    // 时间复杂度 : O(N^2 x m)
    // 空间复杂度 : O(N x m)
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len][m];

        for(int i = 0 ; i < len ; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int[] sum = new int[len]; // 记录前缀和

        //初始化 当k=0 即就有一个分组时
        sum[0] = nums[0];
        dp[0][0] = sum[0];
        for(int i = 1 ; i < len ;i ++){
            sum[i] = sum[i-1] + nums[i];
            dp[i][0] = sum[i];
        }

        for(int i = 0 ; i < len ;i++){
            for(int k = 1; k < m ;k++){
                for(int j = k-1 ; j < i ;j ++){
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k-1], (sum[i]-sum[j])));
                }
            }
        }
        return dp[len-1][m-1];
    }

    // 官方题解 : 二分查找 + 贪心
    // 时间复杂度: 
    public int splitArray2(int[] nums, int m) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        // 初始化 left 和 right
        for(int i = 0; i < len ; i ++){
            left = Math.max(left,nums[i]);
            right += nums[i];
        }

        // 进行二分查找
        while(left < right){
            int mid = (right - left) / 2 + left;
            int cnt = check(nums,mid,m);
            if(cnt <= m){ //特别注意有等号
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    // 计算按照数组和的最大值x进行分割, 所得到的数组的数量
    private int check(int[] nums, int x , int m){
        int len = nums.length;
        int sum = 0; // 用于记录所有分组和
        int cnt = 1; // 起始的时候分组只有1个

        for(int i = 0 ; i < len ; i++){
            if(sum + nums[i] <= x){
                sum += nums[i];
            }else{
                sum = nums[i];
                cnt ++;
            }
        }
        return cnt;
    }
}
