package Algorithm.Search.Backtracking.CombinationSum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        backTrace(candidates, 0, target,  new ArrayList<Integer>());
        return res;
    }

    private void backTrace(int[] candidates, int index, int target, List<Integer> tmpResult){
        int len = candidates.length;
        if(target == 0){
            res.add(new ArrayList<Integer>(tmpResult));
            return;
        }

        for(int i = index ; i < len ; i ++){
            int tmp = target - candidates[i];
            if(tmp < 0){
                continue;
            }
            target = tmp;
            tmpResult.add(candidates[i]);
            backTrace(candidates, i, target, tmpResult);

            //回溯
            tmpResult.remove(tmpResult.size()-1);
            target += candidates[i];
        }
    }
}
