package Algorithm.DynamicProgramming.KnapsackDynamicProgramming.TargetSum_494;

public class Solution {
    int res;
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        recursion(nums, S, 0);
        return res;
    }

    private void recursion(int[] nums, int S , int index){
        if(index == nums.length){
            if(S == 0){
                res++;
            }
            return;
        }

        recursion(nums, S - nums[index], index+1);
        recursion(nums, S + nums[index], index+1);
    }
}
