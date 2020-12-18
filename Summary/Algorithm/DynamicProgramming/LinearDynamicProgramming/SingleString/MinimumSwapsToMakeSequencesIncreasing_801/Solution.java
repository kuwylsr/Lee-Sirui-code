package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.MinimumSwapsToMakeSequencesIncreasing_801;

import java.util.Arrays;

public class Solution {

    // 解法1 
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[][] dp = new int[len][2]; //dp[i][0],代表第i个数不交换; dp[i][1],代表将第i个数交换.

        dp[0][0] = 0;
        dp[0][1] = 1;
        for(int i = 1 ; i < len ; i++){
            // 交换的时候有两种选择, 交换第i个数字 或者 交换第i-1个数字
            if((A[i-1] < A[i] && B[i-1] < B[i]) && (A[i-1] < B[i] && B[i-1] < A[i])){ //此时就是 交换,不交换均可,都严格递增
                dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + 1;
            }else if(A[i-1] < A[i] && B[i-1] < B[i]){ // 此时不交换可以, 交换就不行了(或者两位数字一起交换)
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            }else if(A[i-1] < B[i] && B[i-1] < A[i]){ // 此时交换可以, 不交换不行
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            }
        }
        return Math.min(dp[len-1][0], dp[len-1][1]);
    }


    // 网友解法2 : 
    public int minSwap2(int[] A, int[] B) {
        int len = A.length;
        int[][] dp = new int[len][2]; //第二维为0 ,代表第i个数不交换; 为1, 代表将第i个数交换.
        for(int[] inner : dp){
            Arrays.fill(inner,Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = 1;
        for(int i = 1 ; i < len ; i++){
            if(A[i] > A[i-1] && B[i] > B[i-1]){ //此时,理论上不换就可以保持前i个数的数组严格单调
                dp[i][0] = Math.min(dp[i][0],dp[i-1][0]);
                dp[i][1] = Math.min(dp[i][1],dp[i-1][1]+1);
            }

            if(A[i] > B[i-1] && B[i] > A[i-1]){
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + 1);
            } 
        }
        return Math.min(dp[len-1][0], dp[len-1][1]);
    }
}
