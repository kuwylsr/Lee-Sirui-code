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
        backTrace(nums,tmpResult,isVisited);
        return res;
    }

    /**
     * 
     * @param nums 要遍历的集合数组
     * @param num 当前已经选中的数字的个数
     * @param tmpResult 保存当前选中的结果的集合
     * @param isVisited 记录数字是否被访问过的数组
     */
    private void backTrace(int[] nums, List<Integer> tmpResult, boolean[] isVisited){
        int len = nums.length;
        if(tmpResult.size() == len){
            res.add(new ArrayList<>(tmpResult));
            return;
        }

        for(int i = 0 ; i < len ; i++){
            if(isVisited[i] == false){
                tmpResult.add(nums[i]);
                isVisited[i] = true;
                backTrace(nums, tmpResult, isVisited);

                // 回溯
                tmpResult.remove(tmpResult.size()-1);
                isVisited[i] = false;
            }
        }
    }
}
