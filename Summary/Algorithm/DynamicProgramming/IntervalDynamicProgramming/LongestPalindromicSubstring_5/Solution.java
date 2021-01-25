package Algorithm.DynamicProgramming.IntervalDynamicProgramming.LongestPalindromicSubstring_5;

public class Solution {

    // 个人解法 : boolean[][] 数组存储状态
    public String longestPalindrome(String s) {
        int slen = s.length();
        boolean[][] dp = new boolean[slen][slen];

        String res = ""+s.charAt(0);
        int maxlen = 1; 
        // 初始化 子串长度len==1和len==2
        for(int i = 0 ; i < slen ; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < slen-1 ;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                if(maxlen < 2){
                    maxlen = 2;
                    res = s.substring(i,i+2);
                }
            }
        }

        for(int len = 3 ; len <= slen ; len++){
            for(int i = 0 ; i <= slen - len ; i++){
                int j = len + i - 1;
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    dp[i][j] = dp[i+1][j-1];
                }

                if(dp[i][j] && len > maxlen){
                    maxlen = len ;
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    // 个人解法2 : 直接用的String[][] 存储, 结果超时
    public String longestPalindrome2(String s) {
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
