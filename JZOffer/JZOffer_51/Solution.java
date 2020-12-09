package JZOffer_51;

import java.util.Arrays;

public class Solution {


    // 暴力算法
    // 时间复杂度 : O(N^2)
    // 空间复杂度 : O(1)
    public int reversePairs(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 官方题解: 归并排序
    // 时间复杂度 : O(NlogN)
    // 空间复杂度 : O(N)
    static int[] tmp; // 临时数组

    public int reversePairs2(int[] nums) {
        int[] arr = Arrays.copyOf(nums,nums.length);
        tmp = new int[arr.length];
        int count = mergeSort(arr,0,arr.length-1);
        return count;
    }

    private int mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return 0;
        }
        int mid = (int)Math.floor((start+end)/2);

        int leftpairs = mergeSort(arr,start,mid);
        int rightpairs = mergeSort(arr,mid+1,end);

        if(arr[mid] <= arr[mid+1]){ //如果两个待归并的序列已经有序,直接返回
            return leftpairs + rightpairs;
        }

        int crosspairs = mergeAndCount(arr,start,mid,end);

        return leftpairs + rightpairs + crosspairs;
    }


    /**
     * 两个有序序列归并为一个有序序列,并计算两个序列之间的 逆序对数 (crosspairs)
     * @param arr
     * @param start
     * @param mid
     * @param end
     * @return
     */
    private int mergeAndCount(int[] arr, int start, int mid, int end){
        int count = 0;

        int p1 = start;
        int p2 = mid + 1;
        int index = start;
        while(p1 <= mid || p2 <= end){
            if(p1>mid){
                tmp[index++] = arr[p2++];
            }else if(p2>end){
                tmp[index++] = arr[p1++];
            }else{
                if(arr[p1] <= arr[p2]){
                    tmp[index++] = arr[p1++];
                }else{
                    tmp[index++] = arr[p2++];
                    count += (mid - p1 + 1);
                }
            }
        }
        for(int i = start ; i <= end; i++){
            arr[i] = tmp[i];
        }
        return count;
    }
}
