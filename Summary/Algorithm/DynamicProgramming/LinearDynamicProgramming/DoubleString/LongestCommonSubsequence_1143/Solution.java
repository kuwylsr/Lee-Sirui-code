package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.LongestCommonSubsequence_1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] clist1 = text1.toCharArray();
        char[] clist2 = text2.toCharArray();
        int[][] dp = new int[len1+1][len2+1];

        // 初始化(第一行(i==0)和第一列(j==0))
        // 创建数组的时候,第一行和第一列已经是0, 表示空串与任何串的公共自序列长度都为0

        for(int i = 1 ; i <= len1 ;i ++){
            for(int j = 1 ; j <= len2 ;j++){
                if(clist1[i-1] == clist2[j-1]){ //注意下标, dp[i][j]在这里表示的是前i-1个字符,和前j-1个字符
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    // dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
