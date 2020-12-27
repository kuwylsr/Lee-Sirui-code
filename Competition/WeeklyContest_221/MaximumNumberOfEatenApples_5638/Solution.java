package WeeklyContest_221.MaximumNumberOfEatenApples_5638;

import java.util.PriorityQueue;

public class Solution {


    // 贪心 + 优先队列(最小堆)
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1,o2) -> o1[1]-o2[1]);
        int len = apples.length;
        
        int i = 1; //从第1天开始
        int sum = 0;
        while(!queue.isEmpty() || i <= len){

            // 生成第i天的果子
            if(i <= len){
                queue.add(new int[]{apples[i-1],i+days[i-1]-1}); //第一维是苹果个数, 第二维是保鲜的截止日期(没坏) 
            }

            // 清除腐烂的果子
            while(!queue.isEmpty()){
                int num = queue.peek()[0];
                int early = queue.peek()[1];
                if(num <= 0 || early < i){
                    queue.poll();
                }else{
                    break;
                }
            }

            // 查看今天能否吃到新鲜的果子
            if(!queue.isEmpty()){
                int num = queue.peek()[0];
                int early = queue.peek()[1];
                sum++;
                // 更新
                queue.poll();
                queue.add(new int[]{num-1,early});
            }
            i++;   
        }
        return sum;
    }
}
