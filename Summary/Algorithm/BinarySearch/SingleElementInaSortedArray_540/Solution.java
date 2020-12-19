package Algorithm.BinarySearch.SingleElementInaSortedArray_540;

public class Solution {

    // 个人解法: 二分查找
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int left = 0;
        int right = len - 1;

        while(right - left + 1 > 3){
            int mid = left + (right - left)/2;
            int flag = (mid + 1) % 2; // 计算每个半区元素个数(包含mid)的奇偶性
            if(nums[mid-1] == nums[mid]){
                if(flag == 0){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else if(nums[mid+1] == nums[mid]){
                if(flag == 0){
                    right = mid - 1;
                }else{
                    left = mid;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[left] == nums[left+1] ? nums[right] : nums[left];
    }

    // 官方题解: 二分搜素
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean flag = (right - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (flag) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (flag) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

}
