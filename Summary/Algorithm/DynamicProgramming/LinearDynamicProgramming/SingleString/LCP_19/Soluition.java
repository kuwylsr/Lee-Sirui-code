package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LCP_19;

public class Soluition {
    public int minimumOperations(String leaves) {
        int len = leaves.length();
        char[] clist = leaves.toCharArray();

        int[][] dp = new int[len][3];
        
        // 初始化(i==0)
        dp[0][0] = clist[0] == 'y' ? 1 : 0;
        dp[0][1] = 100000; //设置为一个大数,代表无限次操作
        dp[0][2] = 100000; 

        for(int i = 1 ; i < len ; i++){
            if(clist[i] == 'r'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]);
            }else if(clist[i] == 'y'){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + 1;
            }
        }
        return dp[len-1][2];
    }
}
