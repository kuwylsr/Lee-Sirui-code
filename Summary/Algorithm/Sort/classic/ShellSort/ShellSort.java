package Algorithm.Sort.classic.ShellSort;

import java.util.Arrays;

public class ShellSort {
    // 希尔排序 (升序排序)
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int gap = arr.length; //组数
        while (true) {
            gap /= 2; // 增量每次减半
            for (int i = 0; i < gap; i++) { //遍历每个组(增量序列)
                for (int j = i + gap; j < arr.length; j += gap) {// 这个循环里其实就是一个插入排序
                    int temp = arr[j];
                    int k = j;
                    while (k > gap && temp < arr[k-gap]) {
                        arr[k] = arr[k-gap];
                        k -= gap;
                    }
                    arr[k] = temp;
                }
            }
            if (gap == 1) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int[] arr = { 1, 2, 13, 4, 3, 3, 9, 11, 8, 3, 7 };
        int[] ans = ss.sort(arr);
        for (int i : ans) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
