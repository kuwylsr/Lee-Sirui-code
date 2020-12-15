package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.DecodeWays_91;

import java.util.Arrays;

public class Soluton {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp,0);

        if(len == 1){
            return Integer.parseInt(s.charAt(0)+"") == 0 ? 0:1;
        }
        
        int n1 = Integer.parseInt(s.charAt(0)+"");
        int n2 = Integer.parseInt(s.charAt(1)+"");
        if(n1 == 0){
            return 0;
        }else{
            dp[0] = 1;
            int sum = n1 * 10 +n2;
            if(n2 == 0){
                if(sum >= 1 && sum <= 26){
                    dp[1] = 1;
                }else{
                    dp[1] = 0;
                }
            }else{
                if(sum >= 1 && sum <= 26){
                    dp[1] = 2;
                }else{
                    dp[1] = 1;
                }
            }
        }

        for(int i = 2 ; i< len ;i ++){
            if(arr[i-1] == '0'){
                if(arr[i] == '0'){
                    return 0;
                }else{
                    dp[i] = dp[i-1];
                }
            }else{
                int conNum = (arr[i-1]-'0')*10+(arr[i]-'0');
                if(arr[i] == '0'){
                    if(conNum >= 1 && conNum <= 26){
                        dp[i] = dp[i-2];
                    }else {
                        return 0;
                    }
                }else{
                   if(conNum >= 1 && conNum <= 26){
                        dp[i] = dp[i-1] + dp[i-2];
                    }else {
                        dp[i] = dp[i-1];
                    } 
                }
            }
        }
        return dp[len-1];
    }
}
