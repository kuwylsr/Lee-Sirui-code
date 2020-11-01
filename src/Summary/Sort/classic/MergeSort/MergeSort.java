package Summary.Sort.classic.MergeSort;

import java.util.Arrays;

public class MergeSort {

    static int[] tmp; // 设置临时数组

    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 自顶向下,不断二分,然后在向上二路归并
     * @param arr
     * @param start
     * @param end
     */
    public void mergeSort(int[] arr, int start, int end) {

        if (start >= end) { // 递归终止条件
            return;
        }
        int middle = (int) Math.floor((start + end) / 2); // 向下取整
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    public void merge(int[] arr, int start, int middle, int end) {
        int p1 = start; // 第一个数组的起始位置
        int p2 = middle + 1; // 第二个数组的起始位置
        int index = start; // 记录合并数组下标
        while (p1 <= middle || p2 <= end) {
            if (p1 > middle) {
                tmp[index++] = arr[p2++];
            } else if (p2 > end) {
                tmp[index++] = arr[p1++];
            } else {
                if (arr[p1] <= arr[p2]) {
                    tmp[index++] = arr[p1++];
                } else {
                    tmp[index++] = arr[p2++];
                }
            }
        }
        for(int i = start; i <= end; i++) { //将当前合并后的结果更新到arr数组的对应位置
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] sourceArray = { 2, 3, 1, 6, 8, 7, 3, 2 };
        int[] ans = ms.sort(sourceArray);
        for (int i : ans) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
