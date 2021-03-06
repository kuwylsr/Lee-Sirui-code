package Algorithm.Sort.classic.RadixSort;

import java.util.Arrays;

public class RadixSort {
    
    public int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            // int[][] counter = new int[mod * 2][0];

            //这里不需要每次都new一个mod * 2行大小的二维数组,只需要初始化10(或20行即可)个桶,因为我们每次只提取数字的一位(0~9)
            int[][] buckets = new int[10][0]; 

            for (int j = 0; j < arr.length; j++) {
                // int bucket = ((arr[j] % mod) / dev) + mod;

                // 这里也不需要再加一个 mod ,因为我们只需要将其分到0~9桶中的一个即可.
                // 提取个位 (num % 10) / 1; 提取十位 (num % 100) / 10 ...以此类推
                int index = ((arr[j] % mod) / dev);

                buckets[index] = arrayAppend(buckets[index], arr[j]);
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] arr = {224,222,223,4,3,3,9,11,8,3,7};
        int[] ans = rs.sort(arr);
        for(int i : ans){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
