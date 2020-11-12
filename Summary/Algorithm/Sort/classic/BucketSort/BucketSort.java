package Algorithm.Sort.classic.BucketSort;

import java.util.Arrays;

import Algorithm.Sort.classic.InsertSort.InsertSort;

public class BucketSort {
    
    private static final InsertSort insertSort = new InsertSort();

    public int[] arrAppend(int[] arr, int value){
        arr = Arrays.copyOf(arr, arr.length+1);
        arr[arr.length-1] = value;
        return arr;
    }

    public int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;

        int bucketSize = 5; // 定义桶的大小
        int minValue = arr[0];
        int maxValue = arr[0];
        for(int num : arr){
            if(num > maxValue){
                maxValue = num;
            }else if(num < minValue){
                minValue = num;
            }
        }
        
        // 需要的桶的数量
        int bucketCount = (int)Math.floor((maxValue - minValue)/bucketSize) + 1;
        // 定义桶
        int[][] buckets = new int[bucketCount][0]; //初始化桶的大小为0, 因为数据可能分布不均,需要随时扩展桶的大小
        
        // 利用映射函数将数据分配到各个桶中
        for(int i = 0 ;i < len ; i++){
            int index = (int)Math.floor((arr[i] - minValue)/bucketSize); // 映射函数: (x-minValue)/bucketSize
            buckets[index] = arrAppend(buckets[index], arr[i]); //扩展桶,并将该数字放入该桶中
        }

        // 进行每个元素个数大于0的桶进行桶内排序, 这里选用的是插入排序
        int index = 0;
        for(int[] bucket : buckets){
            if(bucket.length == 0){
                continue;
            }
            bucket = insertSort.sort(bucket);
            // 将元素都放入结果数组当中
            for(int num : bucket){
                arr[index++] = num;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        int[] arr = {1,2,13,4,3,3,9,11,8,3,7};
        int[] ans = bs.sort(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
