package WeeklyContest_220.MaximumErasureValue_1695;

import java.util.Arrays;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int[] preSum = new int[len];
        int[] tmp = new int[len];
        
        preSum[0] = nums[0];
        for(int i = 1 ; i < len ;i ++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        Arrays.fill(tmp,0);
        for(int i = 1 ; i < len ;i++){
            boolean flag = false; //不存在j
            int j = i-1;
            for(; j >= tmp[i-1] ;j--){
                if(nums[j] == nums[i]){
                    flag = true;
                    break;
                }
            }
            int tmp_max;
            if(flag){
                tmp_max = preSum[i] - preSum[j];
                tmp[i] = j+1;
            }else{
                tmp_max = preSum[i] - preSum[tmp[i-1]] + nums[tmp[i-1]];
                tmp[i] = tmp[i-1];
            }
            max = Math.max(max,tmp_max);
        }
        return max;
    }
}
