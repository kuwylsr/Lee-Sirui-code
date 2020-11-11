package Algorithm.Sort.HowManyNumbersAreSmallerThantheCurrentNumber_1365;

public class Solution {

    // 个人解法: 计数排序改编
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        int bucket_len = maxValue + 1;
        int[] bucket = new int[bucket_len];

        for (int num : nums) {
            for (int i = num+1; i <= maxValue; i++) {
                bucket[i]++;
            }
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = bucket[nums[i]];
        }
        return ans;
    }

    // 官方题解: 计数排序
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        int bucket_len = maxValue + 1;
        int[] bucket = new int[bucket_len];

        // counting
        for (int num : nums) {
            bucket[num] ++;
        }

        // 累计计算比i小的元素个数
        for(int i = 1; i < bucket_len; i++) {
            bucket[i] += bucket[i-1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 : bucket[nums[i] - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8,1,2,2,3};
        int[] ans = solution.smallerNumbersThanCurrent2(nums);
        for(int num : ans){
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
