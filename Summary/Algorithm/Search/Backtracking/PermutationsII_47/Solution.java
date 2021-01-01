package Algorithm.Search.Backtracking.PermutationsII_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        res = new ArrayList<List<Integer>>();
        // boolean[] isVisited = new boolean[len]; //默认全初始化为false
        backTrace(nums,new ArrayList<Integer>(), new boolean[len]);
        return res;
    }

    private void backTrace(int[] nums, List<Integer> tmpResult, boolean[] isVisited){
        int len = nums.length;
        if(tmpResult.size() == len){
            res.add(new ArrayList<Integer>(tmpResult));
            return;
        }

        for(int i = 0 ; i < len ; i++){
            if(i>0 && nums[i] == nums[i-1] && isVisited[i-1] == false){ //去重
                continue;
            }

            if(isVisited[i] == false){
                tmpResult.add(nums[i]);
                isVisited[i] = true;
                backTrace(nums,tmpResult,isVisited);

                // 回溯
                tmpResult.remove(tmpResult.size()-1);
                isVisited[i] = false;
            }
        }
    }
}
