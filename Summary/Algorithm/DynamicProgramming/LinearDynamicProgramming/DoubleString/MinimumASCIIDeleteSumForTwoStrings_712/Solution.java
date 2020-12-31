package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.MinimumASCIIDeleteSumForTwoStrings_712;

public class Solution {
    
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] clist1 = s1.toCharArray();
        char[] clist2 = s2.toCharArray();
        int[][] dp = new int[len1+1][len2+1];

        // 初始化(第一行(i==0)和第一列(j==0))
        // 需要全部删掉才能与空串相同
        dp[0][0] = 0;
        for(int i = 1 ; i <= len1 ; i++){
            dp[i][0] = dp[i-1][0] + (int)clist1[i-1];
        }
        for(int j = 1; j <= len2 ; j++){
            dp[0][j] = dp[0][j-1] + (int)clist2[j-1];
        }

        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ;j++){
                if(clist1[i-1] == clist2[j-1]){ //注意下标, dp[i][j]在这里表示的是前i-1个字符,和前j-1个字符
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // dp[i][j] = Math.min(dp[i-1][j] + (int)clist1[i-1], Math.min(dp[i][j-1]+(int)clist2[j-1], dp[i-1][j-1] + (int)clist1[i-1] + (int)clist2[j-1]));
                    dp[i][j] = Math.min(dp[i-1][j] + (int)clist1[i-1], dp[i][j-1]+(int)clist2[j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
