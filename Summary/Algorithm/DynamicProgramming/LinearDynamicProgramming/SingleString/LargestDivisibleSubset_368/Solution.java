package Algorithm.DynamicProgramming.LinearDynamicProgramming.SingleString.LargestDivisibleSubset_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // 个人解法 : 动态规划 (使用HashMap数据结构)
    public List<Integer> largestDivisibleSubset(int[] nums) {

        // 声明一个map, key值为nums数组的下标, value值为它的最大整除子集
        Map<Integer,List<Integer>> dp = new HashMap<Integer,List<Integer>>();
        Arrays.sort(nums);

        int len = nums.length;

        if(len == 0){
            return new ArrayList<Integer>();
        }

        // 初始化dp
        for(int i = 0 ; i < len ; i++){
            List<Integer> tmpList = new ArrayList<Integer>();
            tmpList.add(nums[i]);
            dp.put(i, tmpList);
        }

        int index_max = 0;
        for(int i = 1 ; i < len ; i++){
            int tmp_max = Integer.MIN_VALUE;
            int tmp_index = 0;
            for(int j = 0; j < i ; j++){
                if(nums[i] % nums[j] == 0 && dp.get(j).size() > tmp_max){
                    tmp_max = dp.get(j).size();
                    tmp_index = j;
                }
            }
            
            if(tmp_max != Integer.MIN_VALUE){
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(dp.get(tmp_index)); //进行浅拷贝
                list.add(nums[i]);
                dp.put(i, list);
            }
            if(dp.get(i).size() > dp.get(index_max).size()){
                index_max = i;
            }
        }

        return dp.get(index_max);
    }

    // 网友解法 : 动态规划, 使用数组
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return new ArrayList<Integer>();
        }
        int[] dp = new int[len];

        Arrays.sort(nums);
        Arrays.fill(dp,1);

        int max_index = 0;
        int max_len = 1;
        for(int i = 1 ; i < len ; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }

            if(dp[i] > max_len){
                max_index = i;
                max_len = dp[i];
            }
        }

        // 通过max_index和max_len找出一个解 即可.
        // 难点*
        List<Integer> res = new ArrayList<Integer>();
        for(int i = max_index ; i >=0 ;i--){
            if(dp[i] == max_len && nums[max_index] % nums[i] == 0){
                res.add(nums[i]);
                max_len --;
                max_index = i;
            }
        }
        return res;
    }
}
