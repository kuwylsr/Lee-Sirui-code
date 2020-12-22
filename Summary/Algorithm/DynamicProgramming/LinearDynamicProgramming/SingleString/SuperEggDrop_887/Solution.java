package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.SuperEggDrop_887;

import java.util.Arrays;

public class Solution {

    // 动态规划(超时)
    // 空间复杂度 : O(KN^2)
    // 空间复杂度 : O(KN)
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K]; // N+1层楼(因为有第0层), K个鸡蛋

        Arrays.fill(dp[0],0); // 初始化第一行(第0层)
        Arrays.fill(dp[1],1); // 初始化第二行(第一层)
        for(int i = 1 ; i < N+1 ; i++){
            dp[i][0] = i; // 初始化第一列
        }

        for(int i = 2 ; i < N+1 ; i++){
            for(int k = 1 ; k < K; k++){
                int tmp_min = Integer.MAX_VALUE;
                for(int x = 1 ; x <= i ; x ++){
                    tmp_min = Math.min(tmp_min,Math.max(dp[x-1][k-1],dp[i-x][k]));
                }
                dp[i][k] = 1+tmp_min;
            }
        }
        return dp[N][K-1];
    }

    // 动态规划 + 二分搜索
    // 时间复杂度 : O(KNlogN)
    // 空间复杂度 : O(KN)
    public int superEggDrop2(int K, int N){
        int[][] dp = new int[N+1][K]; // N+1层楼(因为有第0层), K个鸡蛋

        Arrays.fill(dp[0],0); // 初始化第一行(第0层)
        Arrays.fill(dp[1],1); // 初始化第二行(第一层)
        for(int i = 1 ; i < N+1 ; i++){
            dp[i][0] = i; // 初始化第一列
        }

        for(int i = 2 ; i < N+1 ; i++){
            for(int k = 1 ; k < K; k++){
                int left = 1;
                int right = i;
                while(left + 1 < right){
                    int x = left + (right - left)/2; //中间值
                    int t1 = dp[x-1][k-1]; //关于x单调递增
                    int t2 = dp[i-x][k]; //关于x单调递减

                    if(t1 < t2){
                        left = x;
                    }else if(t1 > t2){
                        right = x;
                    }else{
                        left = x;
                        right = x;
                        break;
                    }
                }
                // 分别用left和right作为x, 取最小值.
                dp[i][k] = 1 + Math.min(Math.max(dp[left-1][k-1],dp[i-left][k]), Math.max(dp[right-1][k-1],dp[i-right][k]));
            }
        }
        return dp[N][K-1];
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int N = 6;
        int K = 2;
        int ans = solution.superEggDrop(K, N);
        System.out.println(ans);
    }
}
