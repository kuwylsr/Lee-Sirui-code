package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.EditDistance_72;

public class Solution {
    public int minDistance(String word1, String word2) {
        char[] clist1 = word1.toCharArray();
        char[] clist2 = word2.toCharArray();
        int len1 = clist1.length;
        int len2 = clist2.length;
        int dp[][] = new int[len1+1][len2+1];

        // 初始化
        for(int i = 0 ; i <= len1 ; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2 ; j++){
            dp[0][j] = j;
        }

        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ;j++){
                if(clist1[i-1] == clist2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
