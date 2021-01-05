package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.WildcardMatching_44;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] clist1 = s.toCharArray();
        char[] clist2 = p.toCharArray();
        int len1 = clist1.length;
        int len2 = clist2.length;
        boolean[][] dp = new boolean[len1+1][len2+1];

        // 初始化
        dp[0][0] = true;
        for(int i = 1 ; i <= len1 ;i++){
            dp[i][0] = false;
        }
        for(int j = 1; j <= len2 ; j++){
            if(clist2[j-1] == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }

        for(int i = 1; i <=len1 ;i++){
            for(int j = 1; j <=len2 ;j++){
                if(clist1[i-1] == clist2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(clist2[j-1] == '?'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(clist2[j-1] == '*'){
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j]);
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
