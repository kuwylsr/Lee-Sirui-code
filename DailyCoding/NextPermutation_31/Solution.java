package NextPermutation_31;

import java.util.Arrays;

public class Solution {

    // 个人解法: 比较慢
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return;
        }
        int tmp_min = Integer.MAX_VALUE;
        int tmp_max_index = - 1;
        int flag = 0;
        int i = len - 2;
        for(; i >= 0 ; i--){
            tmp_min = Integer.MAX_VALUE;
            tmp_max_index = - 1;
            for(int j = i + 1 ; j < len ; j++){ //找到比当前数字大的最小数字
                if(nums[j] > nums[i] && nums[j] < tmp_min){
                    tmp_max_index = j;
                    tmp_min = nums[j];
                }
            }
            if(tmp_max_index != -1){
                swap(tmp_max_index, i, nums);
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            Arrays.sort(nums);
        }else{
            Arrays.sort(nums,i+1,len); // 将交换过的位置之后的所有数字升序排序
        }
    }
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }

    // 官方题解 :
    public void nextPermutation2(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return;
        }

        int i = len - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        if(i < 0){
            Arrays.sort(nums);
        }else{
            int tmp_index = -1;
            int tmp_min = Integer.MAX_VALUE;
            for(int j = i + 1 ; j < len;j++){
                if(nums[j] > nums[i] && nums[j] < tmp_min){
                    tmp_index = j;
                    tmp_min = nums[j];
                }
            }
            if(tmp_index != -1){
                swap(i, tmp_index, nums);
                Arrays.sort(nums,i+1,len);
            }
        }
    }
}
