package WeeklyContest_222.WaysToSplitArrayIntoThreeSubarrays_5643;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 个人解法 : 前缀和 + 回溯 (超时.....)
    // 时间复杂度: O(N^2)
    // 空间复杂度: O(N)
    int count = 0;
    public int waysToSplit(int[] nums) {
        
        int len = nums.length;
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        for(int i = 1; i < len ; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        
        backTrace(preSum, 0, new ArrayList<Integer>());
        return count;
    }
    
    private void backTrace(int[] preSum, int index, List<Integer> tmpResult){
        int len = preSum.length;
        if(tmpResult.size() == 2){
            int left = preSum[tmpResult.get(0)];
            int mid = preSum[tmpResult.get(1)] - left;
            int right = preSum[len-1] - preSum[tmpResult.get(1)];
            
            if(left <= mid && mid <= right){
                count = (int)((count + 1) % (Math.pow(10,9) + 7));
            }
            return;
        }
        
        for(int i = index;  i < len ; i++){
            tmpResult.add(i);
            if(tmpResult.size() == 1 && preSum[i] >= preSum[len-1] - preSum[i]){
                 // 回溯
                tmpResult.remove(tmpResult.size()-1);
                continue;
            }
            backTrace(preSum, i + 1, tmpResult);
            
            // 回溯
            tmpResult.remove(tmpResult.size()-1);
        }
    }


    // 题解: 前缀和 + 二分搜索
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(N)
    public int waysToSplit2(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len];
        preSum[0] = nums[0];

        for(int i = 1 ; i < len ; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        long count = 0;
        for(int i = 0 ; i < len -1;i ++){ // 第一次分割可能的位置

            int left_y = i + 1;
            int right_y = len - 2;
            int tmp_y = -1; // 记录满足要求的第二次分割位置的上界
            while(left_y <= right_y){
                int mid_y = left_y + (right_y - left_y)/2;

                if(preSum[len-1] - preSum[mid_y] < preSum[mid_y] - preSum[i]){ //right区间和 小于 mid区间和
                    right_y = mid_y - 1;
                }else{
                    left_y = mid_y + 1;
                    tmp_y = mid_y; //记录当前满足要求的值
                }
            }

            int left_x = i + 1;
            int right_x = len - 2;
            int tmp_x = -1; // 记录满足要求的第二次分割位置的下界
            while(left_x <= right_x){
                int mid_x = left_x + (right_x - left_x)/2;

                if(preSum[mid_x] - preSum[i] < preSum[i]){ //mid区间和 小于 left区间和
                    left_x = mid_x + 1;
                }else{
                    right_x = mid_x - 1;
                    tmp_x = mid_x; //记录当前满足要求的值
                }
            }
            
            if(tmp_x != -1 && tmp_y != -1 && tmp_y >= tmp_x){
                count = count + (tmp_y - tmp_x + 1);
            }
        }
        return (int)(count%(1e9 + 7));
    }

}
