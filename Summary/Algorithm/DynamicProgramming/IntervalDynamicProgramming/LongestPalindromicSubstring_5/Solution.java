package Algorithm.DynamicProgramming.IntervalDynamicProgramming.LongestPalindromicSubstring_5;

public class Solution {
    public String longestPalindrome(String s) {
        int s_len = s.length();
        String[][] dp = new String[s_len][s_len];

        int max_len = 1;
        int max_i = 0;
        int max_j = 0;
        // 初始化
        for(int i= 0 ; i< s_len ;i++){
            dp[i][i] = s.charAt(i) + "";
        }
        for(int i = 0 ; i < s_len -1 ;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = s.charAt(i) + "" + s.charAt(i+1);
                max_len = 2;
                max_i = i;
                max_j = i+1;
            }
        }

        for(int len = 3; len <= s_len ; len ++){
            for(int i = 0 ; i <= s_len - len ; i++){
                int j = i + len - 1;
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = "";
                }else if(dp[i+1][j-1]==null || dp[i+1][j-1] == ""){
                    dp[i][j] = "";
                }else{
                    dp[i][j] = s.charAt(i) + dp[i+1][j-1] + s.charAt(j);
                }
                if(dp[i][j].length() > max_len){
                    max_len = dp[i][j].length();
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return dp[max_i][max_j];
    }
}
