package JZOffer_14_I;

public class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        
        //初始化
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ;i++){
            for(int j = 1 ; j <= i-1 ;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
