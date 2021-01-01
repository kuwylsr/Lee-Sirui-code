package Algorithm.Search.Backtracking.CombinationSumII_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        res = new ArrayList<List<Integer>>();
        backTrace(candidates, 0, target, new ArrayList<Integer>(), new boolean[len]);
        return res;
    }

    private void backTrace(int[] candidates, int index, int target, List<Integer> tmpResult, boolean[] isVisited){
        int len = candidates.length;
        Arrays.sort(candidates);
        if(target == 0){
            res.add(new ArrayList<Integer>(tmpResult));
            return;
        }

        for(int i = index ; i < len ; i++){
            if(i>0 && candidates[i] == candidates[i-1] && isVisited[i-1] == false){ //去重
                continue;
            }

            int tmp = target - candidates[i];
            if(tmp < 0){
                continue;
            }

            target = tmp;
            tmpResult.add(candidates[i]);
            isVisited[i] = true;
            backTrace(candidates, i+1, target, tmpResult, isVisited);

            //回溯
            tmpResult.remove(tmpResult.size()-1);
            isVisited[i] = false;
            target += candidates[i];
        }
    }
}
