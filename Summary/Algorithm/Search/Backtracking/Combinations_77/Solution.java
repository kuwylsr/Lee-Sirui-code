package Algorithm.Search.Backtracking.Combinations_77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1 ; i<=n ;i++){
            nums[i-1] = i;
        }
        res = new ArrayList<List<Integer>>();
        backTrace(nums, 0, k, new ArrayList<Integer>());
        return res;
    }

    /**
     * 
     * @param nums
     * @param index
     * @param k
     * @param tmpResult
     */
    private void backTrace(int[] nums, int index, int k, List<Integer> tmpResult){
        int len = nums.length;
        if(tmpResult.size() == k){
            res.add(new ArrayList<Integer>(tmpResult));
            return;
        }

        for(int i = index ; i < len ; i++){
            tmpResult.add(nums[i]);
            backTrace(nums, i+1, k, tmpResult);

            //回溯
            tmpResult.remove(tmpResult.size()-1);
        }
    }
}
