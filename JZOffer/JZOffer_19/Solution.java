package JZOffer_19;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] clist_s = s.toCharArray();
        char[] clist_p = p.toCharArray();
        int len1 = clist_s.length;
        int len2 = clist_p.length;

        boolean[][] dp = new boolean[len1+1][len2+1];

        // 初始化
        dp[0][0] = true;
        for(int i = 1 ; i <= len1 ; i++){ // 初始化第0列
            dp[i][0] = false;
        }
        for(int j = 1 ; j <= len2; j++){ // 初始化第0行
            if(clist_p[j-1] == '*'){
                dp[0][j] = dp[0][j-2];
            }else{
                dp[0][j] = false;
            }
        }

        for(int i = 1 ; i<=len1 ; i++){
            for(int j = 1 ; j<=len2 ;j++){
                if(clist_p[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(clist_p[j-1] == '*'){
                    dp[i][j] = (clist_p[j-2] == '.' || clist_p[j-2] == clist_s[i-1]) ? (dp[i-1][j] || dp[i][j-2]) : dp[i][j-2];
                }else{
                    dp[i][j] = clist_s[i-1] == clist_p[j-1] ? dp[i-1][j-1] : false; 
                }
            }
        }
        return dp[len1][len2];
    }
}
