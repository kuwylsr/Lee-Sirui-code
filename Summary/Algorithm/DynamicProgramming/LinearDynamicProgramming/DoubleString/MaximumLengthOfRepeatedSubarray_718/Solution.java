package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.MaximumLengthOfRepeatedSubarray_718;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int max = 0;
        int dp[][] = new int[len1][len2];

        // 初始化第一行和第一列
        for(int i = 0 ; i < len1 ; i++){
            dp[i][0] = A[i] == B[0] ? 1 : 0;
        }
        for(int j = 0 ; j < len2 ;j++){
            dp[0][j] = A[0] == B[j] ? 1 : 0;
        }

        for(int i = 1 ; i < len1 ;i++){
            for(int j = 1; j < len2 ; j++){
                dp[i][j] = (A[i] == B[j]) ? (dp[i-1][j-1] + 1) : 0;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
