package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.LastStoneWeightII_1049;

public class Solution {

    // 动态规划(简化空间)
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        
        int[] dp = new int[(int)(sum/2)+1];

        for(int i = 0 ; i < len ; i++){
            int stone = stones[i];
            for(int j = (int)(sum/2) ; j >= 0 ;j--){
                if(stone <= j){
                    dp[j] = Math.max(dp[j], dp[j-stone]+stone);
                }
            }
        }
        return sum - dp[(int)(sum/2)] * 2;
    }
}
