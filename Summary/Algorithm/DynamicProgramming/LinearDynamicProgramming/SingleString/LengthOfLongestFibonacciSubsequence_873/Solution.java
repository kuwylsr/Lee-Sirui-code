package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LengthOfLongestFibonacciSubsequence_873;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lenLongestFibSubseq(int[] A) {

        int ans = 0;
        Map<Integer, Integer> index_map = new HashMap<Integer, Integer>();
        int len = A.length;

        // 建立值到下标的索引
        for(int i = 0; i < len; i++){
            index_map.put(A[i],i);
        }

        int[][] dp = new int[A.length][A.length];
        
        for(int i = 0 ;i < len ; i++){ // 数组初始化, 全赋值为2
            Arrays.fill(dp[i],2);
        }
        
        for(int i = 0; i < len-1; i++){
            for(int j = i ; j < len; j++){
                int k = index_map.getOrDefault(A[j]-A[i], -1);
                if(k >=0 && k < i){
                    dp[i][j] = dp[k][i]+1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
}
