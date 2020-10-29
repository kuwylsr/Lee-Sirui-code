package _summary.Sort.classic.SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    
    // 选择排序 (升序)
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        int len = arr.length;
        int min_index; // 记录当前最小值的下标

        for(int i = 0; i < len; i++){
            min_index = i;
            for(int j = i ;j< len; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            // 将最小值交换到i位置
            if(min_index != i){
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = {1,2,13,4,3,3,9,11,8,3,7};
        int[] ans = ss.sort(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
