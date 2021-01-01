package Algorithm.Search.Backtracking.Permutations_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tmpResult = new ArrayList<Integer>();
        res = new ArrayList<List<Integer>>();
        int len = nums.length;
        boolean[] isVisited = new boolean[len];
        backTrace(nums,0,tmpResult,isVisited);
        return res;
    }

    private void backTrace(int[] nums, int num, List<Integer> tmpResult, boolean[] isVisited){
        int len = nums.length;
        if(num == len){
            res.add(new ArrayList<>(tmpResult));
            return;
        }

        for(int i = 0 ; i < len ; i++){
            if(isVisited[i] == false){
                tmpResult.add(nums[i]);
                isVisited[i] = true;
                backTrace(nums, num+1, tmpResult, isVisited);

                // 回溯
                tmpResult.remove(tmpResult.size()-1);
                isVisited[i] = false;
            }
        }
    }
}
