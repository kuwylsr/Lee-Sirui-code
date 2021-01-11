package Algorithm.DynamicProgramming.LinearDynamicProgramming.Matrix.Triangle_120;

import java.util.Arrays;
import java.util.List;

public class Solution {

    // 动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size(); // 三角形的行数
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < len ; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        //初始化(第0列)
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1 ; i < len ; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }

        int minSum = dp[len-1][0];
        for(int i = 1; i < len ; i++){
            for(int j = 1 ; j <= i ; j++){
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                if(i == len-1){ //记录最后一行中的最小值
                    minSum = Math.min(minSum, dp[i][j]);
                }
            }
        }
        return minSum;
    }

    // 动态规划 + 滚动数组优化(简化空间)
    // 空间复杂度 : O(n)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size(); // 三角形的行数
        int[] dp = new int[len];
        for(int i = 0 ; i < len ; i++){
            Arrays.fill(dp,Integer.MAX_VALUE);
        }
        if(len == 1){
            return triangle.get(0).get(0);
        }
        //初始化(第0行,第0列)
        dp[0] = triangle.get(0).get(0);

        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i < len ; i++){
            for(int j = i ; j >= 1 ; j--){
                dp[j] = Math.min(dp[j-1],dp[j]) + triangle.get(i).get(j);
                if(i == len-1){ //记录最后一行中的最小值
                    minSum = Math.min(minSum, dp[j]);
                }
            }
            dp[0] += triangle.get(i).get(0); //初始化当前行的第0列
            if(i == len - 1){
                minSum = Math.min(minSum, dp[0]);
            }
        }
        return minSum;
    }
}
