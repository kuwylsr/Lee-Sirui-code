package Algorithm.Sort.classic.QuickSort;

import java.util.Arrays;

public class QuickSort {

    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    /**
     * 快排的主函数
     * 自顶向下,不断分区
     * @param arr 原始数组
     * @param left 待快排的区间的最左侧
     * @param right 待快排的区间的最右侧
     */
    private void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int partitionIndex = partition(arr,left,right);
        quickSort(arr,left,partitionIndex-1);
        quickSort(arr,partitionIndex+1,right);
    }

    /**
     * 根据设定的基准值pivot进行分区
     * @param arr 原始数组
     * @param left 待分区区间的最左侧
     * @param right 待分区区间的最右侧
     * @return
     */
    private int partition(int[] arr, int left, int right){
        // 设定基准值 (pivot)
        int pivot = left; 
        int index = pivot + 1;
        for(int i = left + 1 ; i <= right;i++){
            if(arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index - 1;
    }

    private void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] sourceArray = { 2, 3, 1, 6, 8, 7, 3, 2 };
        int[] ans = qs.sort(sourceArray);
        for (int i : ans) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
