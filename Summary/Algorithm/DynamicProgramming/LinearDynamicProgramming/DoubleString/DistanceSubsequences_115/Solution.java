package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.DistanceSubsequences_115;

public class Solution {
    public int numDistinct(String s, String t) {
        char[] clist1 = s.toCharArray();
        char[] clist2 = t.toCharArray();
        int len1= clist1.length;
        int len2 = clist2.length;
        int[][] dp = new int[len1][len2];
        if(len1 == 0){
            return 0;
        }
        
        //初始化
        dp[0][0] = (clist1[0] == clist2[0]) ? 1 : 0;
        for(int i = 1; i < len1; i++){
            dp[i][0] = (clist1[i] == clist2[0]) ? dp[i-1][0] + 1 : dp[i-1][0];
        }
        for(int j = 1; j < len2;j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < len1 ;i++){
            for(int j = 1 ; j < len2 ;j++){
                if(clist1[i] == clist2[j]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len1-1][len2-1];
    }
}
