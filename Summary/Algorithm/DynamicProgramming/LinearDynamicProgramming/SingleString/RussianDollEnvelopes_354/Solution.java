package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.RussianDollEnvelopes_354;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // 动态规划: 注意此题与 LIS 的区别
    public int maxEnvelopes(int[][] envelopes) {
        // 首先将信封 按宽度 升序排序(*) 重中之重
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
           }
        });

        // 下面和 LIS 一样处理
        int len = envelopes.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;

        for(int i = 1; i < len; i++){
            int tmp_max = Integer.MIN_VALUE;
            for(int j = 0; j < i ;j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    if(dp[j] > tmp_max){
                        tmp_max = dp[j];
                    }
                }
            }
            if(tmp_max == Integer.MIN_VALUE){
                dp[i] = 1;
            }else{
                dp[i] = tmp_max + 1;
            }

            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
