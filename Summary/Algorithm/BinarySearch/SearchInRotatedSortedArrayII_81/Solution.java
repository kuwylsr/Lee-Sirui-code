package Algorithm.BinarySearch.SearchInRotatedSortedArrayII_81;

public class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return true;
            }

            // target != nums[mid]
            if(nums[mid] == nums[left]){ //无法判断单调性, 退化为顺序查找
                // for(int i = left ; i <= right ; i++){
                //     if(target == nums[i]){
                //         return true;
                //     }
                // }
                // return false;
                
                // 如果出现相等的, 只需要跳过这个重复值即可,相当于删除一个重复元素. 
                // 如果正好left==mid,由于mid不是目标解,因此跳过也无所谓.
                left ++; 
            } else if(nums[mid] > nums[left]){ //左区间连续单调增(非严格单调)
                if(target >= nums[left] && target < nums[mid]){ //target在左区间
                    right = mid - 1;
                }else{ //targe在右区间
                    left = mid + 1;
                }
            }else{ //左区间不单调, 那么右区间一定连续单调增(非严格单调)
                if(target > nums[mid] && target <= nums[right]){ //targe在右区间
                    left = mid + 1;
                }else{ //targe在左区间
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
