package Algorithm.BinarySearch.FindMinimumInRotatedSortedArray_153;

public class Solution {


    // 题解: 
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        if(len == 1){
            return nums[0];
        }

        if(nums[0] < nums[len-1]){ //没有旋转
            return nums[0];
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= nums[0]){ //左区间连续单调增, 则最小值一定在右区间
                left = mid + 1;
            }else{ //左区间不单调, 那么右区间一定连续单调增, 则最小值一定在左区间(也可能是mid处取最小)
                right = mid;
            }
        }
        return nums[left];
    }



    // 官方题解 : 
    public int findMin2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        if(len == 1){
            return nums[0];
        }

        if(nums[0] < nums[len-1]){ //没有旋转
            return nums[0];
        }

        while(left <= right){
            int mid = left + (right - left)/2;
        
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }

            if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
