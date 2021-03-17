package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 哈希表 + 动态规划
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        char[] clist = s.toCharArray();
        if(len == 0){
            return 0;
        }
        
        Map<Character,Integer> map = new HashMap<>();
        int[] dp = new int[len];
        dp[0] = 1;
        map.put(clist[0],0);
        int max = 1;

        for(int i = 1 ; i < len ; i++){
            int j = map.getOrDefault(clist[i],-1);
            if(j == -1 || dp[i-1] < i - j){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = i - j;
            }
            max = Math.max(max,dp[i]);
            map.put(clist[i],i); // 更新哈希表, 保留最新(最靠右)的下标
        }
        return max;
    }
}
