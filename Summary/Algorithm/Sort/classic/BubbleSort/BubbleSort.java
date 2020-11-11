package Algorithm.Sort.classic.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    // 冒泡排序 (升序)
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        // 设定一个标记，若为false，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
        boolean flag = false;

        for (int i = len - 2; i >= 0; i--) {
            for(int j = 0 ; j <= i; j++){
                if(arr[j] > arr[j+1]){
                    flag = true; // 进行过交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(flag == false){ //该轮没有交换过元素
                break;
            }else{
                flag = false;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {1,2,13,4,3,3,9,11,8,3,7};
        int[] ans = bs.sort(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
