package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LargestSumOfAverages_813;

public class Solution {

    // 动态规划
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[][] dp = new double[len][K];
        double[] sum = new double[len]; // 用于记录前缀和, 方便计算均值

        //初始化
        sum[0] = A[0];
        dp[0][0] = sum[0]/1;
        for(int i = 1 ; i < len ;i++){
            sum[i] = sum[i-1] + A[i];
            dp[i][0] = sum[i] / (i+1); //初始化第0列
        }
        
        for(int i = 0 ; i< len ;i++){
            for(int k = 1 ; k < K ; k++){
                for(int j = k-1 ; j < i ;j++){
                    dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (sum[i]-sum[j])/(i-j));
                }
            }
        }
        return dp[len-1][K-1];
    }
}
