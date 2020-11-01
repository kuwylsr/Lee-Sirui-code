package WeeklyContest_213.FurthestBuildingYouCanReach_5556;

import java.util.PriorityQueue;

class Solution {

    // 官方解答: 优先队列 +　贪心
    public int furthestBuilding(int[] heights, int bricks, int ladders){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 1 ;i < heights.length ;i ++){
            int vary = heights[i] - heights[i-1];
            if(vary <= 0){
                continue;
            }
            minHeap.add(vary);
            if(minHeap.size() > ladders){ //已经有了目前的前 ladders 大的高度差
                int top = minHeap.peek();
                minHeap.poll();
                bricks -= top;
                if(bricks < 0){
                    return i - 1;
                }
            }
        }
        return heights.length - 1;
    }

    // 个人解法 :错误，解析见文档
    public int furthestBuilding2(int[] heights, int bricks, int ladders) {

        int preHeight = heights[0];
        int remainB = bricks;
        int remainL = ladders;
        int i = 1;
        for(; i < heights.length; i++){
            int tempHeight = heights[i];
            int vary = tempHeight - preHeight;
            // System.out.println(vary);
            if(vary > 0){
                if(vary <= remainB){
                    remainB -= vary;
                }else{
                    if(remainL > 0){
                        remainL --;
                    }else{
                        return i - 1;
                    }
                }
            }
            preHeight = tempHeight;
        }
        return i - 1;
    }
}
