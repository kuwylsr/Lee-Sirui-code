package Algorithm.Search.Backtracking.CombinationSumIII_216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<List<Integer>>();
        backTrace(n,1,k,new ArrayList<Integer>());
        return res;
    }

    private void backTrace(int n ,int index, int k, List<Integer> tmpResult){
        if(tmpResult.size() == k){
            if(n == 0){
                res.add(new ArrayList<Integer>(tmpResult));
            }
            return;
        }

        for(int i = index ; i <= 9 ; i++){
            int tmp = n - i;
            if(tmp < 0){ //剪枝
                continue;
            }

            n = tmp;
            tmpResult.add(i);
            backTrace(n,i+1,k,tmpResult);

            //回溯
            tmpResult.remove(tmpResult.size()-1);
            n += i;
        }
    }
}
