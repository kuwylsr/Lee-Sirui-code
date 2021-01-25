package Algorithm.DynamicProgramming.IntervalDynamicProgramming.PalindromicSubstrings_647;

public class Solution {
    public int countSubstrings(String s) {
        int slen = s.length();
        char[] clist = s.toCharArray();
        boolean[][] dp = new boolean[slen][slen];

        int sum = 0;
        //初始化(回文子串len==1和2)
        for(int i = 0 ; i < slen ; i++){
            dp[i][i] = true;
            sum++;
        }
        for(int i = 0 ; i < slen - 1; i++){
            if(clist[i] == clist[i+1]){
                dp[i][i+1] = true;
                sum++;
            }
        }

        for(int len = 3 ; len <= slen ;len++){
            for(int i = 0 ; i <= slen - len ; i++){
                int j = len + i -1 ;
                if(clist[i] != clist[j]){
                    dp[i][j] = false;
                }else{
                    dp[i][j] = dp[i+1][j-1];
                }

                if(dp[i][j]){
                    sum++;
                }
            }
        }
        return sum;
    }
}
