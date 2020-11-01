package JZOffer_03;

import java.util.*;

public class Solution {

    // 个人解法: 利用 HashSet的 contains() 函数
    // 时间复杂度: O(N); 空间复杂度: O(N)
    public int findRepeatNumber1(int[] nums){
        Set<Integer> s = new HashSet<Integer>();
        for(int num : nums){
            if(s.contains(num)){
                return num;
            }else{
                s.add(num);
            }
        }
        return -1;
    }

    // 官方题解: 利用 HashSet的 add() 函数
    // 时间复杂度: O(N); 空间复杂度: O(N)
    public int findRepeatNumber2(int[] nums){
        Set<Integer> s = new HashSet<Integer>();
        for(int num : nums){
            if(!s.add(num)){
                return num;
            }
        }
        return -1;
    }

    // 指针 + 排序
    // 时间复杂度: O(NlogN); 空间复杂度: O(1)
    public int findRepeatNumber3(int[] nums){
        Arrays.sort(nums);
        int pre=nums[0],p;
        for(int i = 1; i < nums.length; i++){
            p = nums[i];
            if(pre == p){
                return p;
            }else{
                pre = p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }

}
