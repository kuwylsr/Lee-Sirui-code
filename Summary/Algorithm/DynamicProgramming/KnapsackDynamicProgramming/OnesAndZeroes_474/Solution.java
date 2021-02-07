package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.OnesAndZeroes_474;

public class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i < len ; i++){
            int[] tmp = count(strs[i]);
            for(int j = m ; j >= 0 ;j--){
                for(int k = n ; k >= 0 ; k--){
                    if(tmp[0] <= j && tmp[1] <= k){
                        dp[j][k] = Math.max(dp[j][k], dp[j-tmp[0]][k-tmp[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str){
        int m = 0;
        int n = 0;
        char[] clist = str.toCharArray();
        for(char c : clist){
            if(c == '0'){
                m++;
            }else{
                n++;
            }
        }
        return new int[]{m,n};
    }
}
