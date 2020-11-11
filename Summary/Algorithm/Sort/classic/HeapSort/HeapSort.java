package Algorithm.Sort.classic.HeapSort;

import java.util.Arrays;

public class HeapSort {

    /**
     * 初始化建立大根堆
     * 
     * @param arr 存储二叉树的数组
     * @param len 数组的长度
     */
    private void buildHeap(int[] arr, int len) {
        // 注意 一定从最后一个非叶节点开始遍历, 即 len/2 - 1 的位置开始. 不能从i=0开始
        for (int i = (int) (Math.floor(len / 2) - 1); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 调整大根堆
     * 
     * @param arr 存储二叉树的数组
     * @param i   当前要调整的非叶节点,即子树的根
     * @param len 数组的长度
     */
    private void heapify(int[] arr, int i, int len) {

        // 需要知道用数组保存(完全)二叉树, 某个子树的根节点 i 的左右儿子分别为 2*i+1 和 2*i+2

        int left = 2 * i + 1; // 当前根节点i的左儿子节点
        int right = 2 * i + 2; // 当前根节点i的右儿子节点
        int largest = i; // 初始化当前最大节点为 根节点i

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, len); // 继续调整被交换的根节点,注意当前largest是交换之前的i
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildHeap(arr, len);

        // 将大顶堆的堆顶元素交换到堆尾, 然后继续调整大顶堆, 直到没有元素
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len); // 因为我们只改变了堆顶元素,因此可以从堆顶开始调整大根堆
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 8, 5, 9 };
        HeapSort hs = new HeapSort();
        int[] ans = hs.sort(arr);
        for (int i : ans) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
