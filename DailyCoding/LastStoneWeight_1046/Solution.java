package LastStoneWeight_1046;

import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<Integer>((o1,o2) -> (o2-o1)); //最大堆

        for(int stone : stones){
            MaxHeap.add(stone);
        }

        while(MaxHeap.size() >= 2){
            int s1 = MaxHeap.poll();
            int s2 = MaxHeap.poll();
            if(s1 - s2 == 0){
                continue;
            }else{
                MaxHeap.add(s1-s2);
            }
        }
        
        return MaxHeap.size() == 1 ? MaxHeap.peek() : 0;
    }
}
