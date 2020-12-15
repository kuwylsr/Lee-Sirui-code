package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.ArithmeticSlices_413;

import java.util.Arrays;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int len = A.length;
        int[] dp = new int[len];
        Arrays.fill(dp,0);

        if(len < 3){
            return 0;
        }

        for(int i = 2 ; i < len ;i ++){
            if(A[i-1]-A[i-2] == A[i] - A[i-1]){
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
