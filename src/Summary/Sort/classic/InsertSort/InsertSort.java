package Summary.Sort.classic.InsertSort;

import java.util.Arrays;

public class InsertSort {
    
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;

        for(int i = 1 ; i < len ; i++){
            int temp = arr[i]; // 记录要插入的数据
            int j = i;

            // 从已经排序的序列最右边(从后往前)的开始比较，找到比其小的数
            while(j > 0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public int[] sort2(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;

        for(int i = 1 ; i < len ; i++){
            int temp = arr[i];
            int j = i - 1;
            for(; j >= 0 ; j--){
                if(temp < arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    arr[j+1] = temp;
                    break;
                }
            }
            if(j == -1){
                arr[0] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort bs = new InsertSort();
        int[] arr = {1,2,13,4,3,3,9,11,8,3,7};
        int[] ans = bs.sort(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
