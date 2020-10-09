package SortColors_75;

import java.util.*;

public class Solution {
    public void sortColors(int[] nums) {
        int index = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == j) {
                    int tmp = nums[index];
                    nums[index] = j;
                    nums[i] = tmp;
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        S.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}