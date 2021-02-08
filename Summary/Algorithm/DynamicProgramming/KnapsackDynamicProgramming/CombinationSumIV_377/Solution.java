package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.CombinationSumIV_377;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];

        // 初始化
        dp[0] = 1;
        
        // 求排序(考虑顺序)(完全背包)
        for(int j = 1 ; j <= target ; j++){
            for(int i = 0 ; i < len ; i++){
                if(nums[i] <= j){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }


    // 改成01背包
    public int combinationSum42(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];

        // 初始化
        dp[0] = 1;
        
        // 求组合(考虑顺序)(01背包)
        // 由于01背包问题的一维dp, 只能先遍历物品 ,在遍历背包, 因此只能求组合问题
        // 如果01背包问题, 想求排序, 必须用二维dp的相应循环.
        for(int i = 0 ; i < len ; i++){
            for(int j = target ; j > 0 ; j--){
                if(nums[i] <= j){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        
        return dp[target];
    }

    // 改成01背包
    public int combinationSum43(int[] nums, int target) {
        int len = nums.length;
        int[][] dp = new int[len][target+1];

        // 初始化
        dp[0][0] = 1;
        for(int j = 1 ; j <= target ; j++){
            dp[0][j] = nums[0] == j ? 1 : 0;
        }
        
        // 求组合(考虑顺序)(01背包)
        // 由于01背包问题的一维dp, 只能先遍历物品 ,在遍历背包, 因此只能求组合问题
        // 如果01背包问题, 想求排序, 必须用二维dp的相应循环.
        for(int j = 0 ; j <= target ; j++){
            for(int i = 1 ; i < len ; i++){
                if(nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }

    // 改成01背包
    public int combinationSum44(int[] nums, int target) {
        int len = nums.length;
        int[][] dp = new int[len][target+1];

        // 初始化
        dp[0][0] = 1;
        for(int j = 1 ; j <= target ; j++){
            dp[0][j] = nums[0] == j ? 1 : 0;
        }
        
        // 求组合(考虑顺序)(01背包)
        // 由于01背包问题的一维dp, 只能先遍历物品 ,在遍历背包, 因此只能求组合问题
        // 如果01背包问题, 想求排序, 必须用二维dp的相应循环.
        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j <= target ; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5};
        int target = 5;
        int res = solution.combinationSum4(nums, target);
        int res2 = solution.combinationSum42(nums, target);
        int res3 = solution.combinationSum43(nums, target);
        int res4 = solution.combinationSum44(nums, target);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}
