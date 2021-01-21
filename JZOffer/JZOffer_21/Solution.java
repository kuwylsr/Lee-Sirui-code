package JZOffer_21;

public class Solution {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int index = 0; //记录调整之后, 已经排好的奇数个数
        for(int i = 0 ; i < len ; i++){
            if(nums[i] % 2 == 1){
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                index ++;
            }
        }
        return nums;
    }
}
