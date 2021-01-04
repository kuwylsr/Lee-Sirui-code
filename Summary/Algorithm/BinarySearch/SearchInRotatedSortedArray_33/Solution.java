package Algorithm.BinarySearch.SearchInRotatedSortedArray_33;

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
            }

            // target != nums[mid]
            if(nums[mid] >= nums[left]){ //左区间连续单调增
                if(target >= nums[left] && target < nums[mid]){ //target在左区间
                    right = mid - 1;
                }else{ //targe在右区间
                    left = mid + 1;
                }
            }else{ //左区间不单调, 那么右区间一定连续单调增
                if(target > nums[mid] && target <= nums[right]){ //targe在右区间
                    left = mid + 1;
                }else{ //targe在左区间
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
