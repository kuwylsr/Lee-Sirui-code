package Algorithm.DynamicProgramming.LinearDynamicProgramming.DoubleString.InterleavingString_97;

public class Solution {

    // 动态规划 : 
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] clist1 = s1.toCharArray();
        char[] clist2 = s2.toCharArray();
        char[] clist3 = s3.toCharArray();
        int len1= clist1.length;
        int len2= clist2.length;
        int len3= clist3.length;
        
        if(len3 != (len1 + len2)){
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];

        // 初始化
        dp[0][0] = true; //两个空串,是true还是false无所谓的,不影响状态转移
        for(int i = 1 ; i <= len1 ; i++){
            dp[i][0] = (s1.substring(0,i).equals(s3.substring(0,i)));
        }
        for(int j = 1 ; j <= len2 ;j++){
            dp[0][j] = (s2.substring(0,j).equals(s3.substring(0,j)));
        }

        for(int i = 1; i <= len1 ;i++){
            for(int j = 1 ;j <= len2 ;j++){
                if(clist1[i-1] == clist3[i+j-1]){
                    dp[i][j] = dp[i-1][j];
                }
                
                if(clist2[j-1] == clist3[i+j-1]){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
                
                if(clist1[i-1] != clist3[i+j-1] && clist2[j-1] != clist3[i+j-1]){
                    dp[i][j] = false;
                }
            }
        }
        return dp[len1][len2];
    }

    // 动态规划 : 滚动数组,优化空间(略)
    public boolean isInterleave2(String s1, String s2, String s3) {
        return true;
    }
}
