package Algorithm.DynamicProgramming.IntervalDynamicProgramming.LongestPalindromicSubsequence_516;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int slen = s.length();
        char[] clist = s.toCharArray();
        int[][] dp = new int[slen][slen];

        //初始化(子串长度为1和2)
        for(int i = 0 ; i < slen ; i++){
            dp[i][i] = 1;
        }
        for(int i = 0 ; i < slen - 1;i++){
            if(clist[i] == clist[i+1]){
                dp[i][i+1] = 2;
            }else{
                dp[i][i+1] = 1;
            }
        }

        for(int len = 3 ; len <= slen ;len ++){
            for(int i = 0 ; i <= slen - len ; i++){
                int j = len + i - 1;
                if(clist[i] != clist[j]){
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }else{
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
            }
        }
        return dp[0][slen-1];
    }
}
