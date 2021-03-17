package JZOffer_59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {

    // 解法1 : 优先队列(最大堆)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                return o2[0] - o1[0];
            }
        }); 

        int[] res = new int[len - k + 1];

        int i = 0;
        for( ; i < k ; i++){
            maxHeap.offer(new int[]{nums[i],i});
        }
        res[0] = maxHeap.peek()[0];

        for(;i < len ; i++){
            maxHeap.offer(new int[]{nums[i],i});
            while(maxHeap.peek()[1] < i - k + 1){ //找到在当前窗口内的堆顶元素
                maxHeap.poll();
            }
            res[i-k+1] = maxHeap.peek()[0];
        }
        return res;
    }

    // 解法2 : 单调队列(双端队列实现)
    public int[] maxSlidingWindow2(int[] nums, int k){
        int len = nums.length;
        int[] res = new int[len - k + 1];
        if(k == 0){
            return new int[0];
        }

        Deque<int[]> deque = new LinkedList<int[]>();
        for(int i = 0; i < len ; i++){
            while(!deque.isEmpty() && deque.peekLast()[0] < nums[i]){ // 维护单调性(单调递减)
                deque.pollLast();
            }
            deque.offerLast(new int[]{nums[i],i});
            
            if(deque.peekFirst()[1] < i - k + 1){ //保证为窗口内的值
                deque.pollFirst();
            }
            if(i>=k-1){ // 从第一个窗口开始计算结果
                res[i-k+1] = deque.peekFirst()[0];
            }
            
        }
        return res;
    }
}
 