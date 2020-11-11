package Algorithm.Sort.classic.CountingSort;

import java.util.Arrays;

public class CountingSort {
    
    public int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        
        int maxValue = Integer.MIN_VALUE;
        for(int num : arr){
            if (num > maxValue){
                maxValue = num;
            }
        }

        // 以数的最大值maxValue+1开辟数组空间
        int bucket_len = maxValue+1;
        int[] bucket = new int[bucket_len];
        
        Arrays.fill(bucket,0);

        //counting
        for(int num : arr){
            bucket[num] ++;
        }

        //output
        int index = 0;
        for(int i = 0 ; i < bucket_len ;i ++){
            int frequency = bucket[i];
            while(frequency > 0){
                arr[index++] = i;
                frequency--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int[] arr = {1,2,13,4,3,3,9,11,8,3,7};
        int[] ans = cs.sort(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
