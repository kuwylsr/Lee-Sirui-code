package Algorithm.BinarySearch.FindMinimumInRotatedSortedArrayII_154;

public class Solution {

    // 二分搜索: 利用右指针判断
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];
    }

    // 二分搜索 : 左指针 (https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/guan-fang-yong-you-zhi-zhen-wo-pian-yao-yong-zuo-z/)
}
