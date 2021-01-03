package WeeklyContest_222.MaximumUnitsOnATruck_5641;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // 使用优先队列进行排序
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1,o2) -> o2[1]-o1[1]); //使用lamdba表达式重写匿名函数.
        int len = boxTypes.length;
        // 初始化
        for(int i = 0 ; i < len ;i++){
            q.add(boxTypes[i]);
        }
        
        int maxSum = 0;
        while(truckSize > 0 && !q.isEmpty()){
            int tmpNum = q.peek()[0];
            int value = q.peek()[1];
            
            if(truckSize - tmpNum <= 0){
                maxSum += truckSize * value;
                truckSize = 0;
            }else{
                maxSum += tmpNum * value;
                q.poll();
                truckSize -= tmpNum;
            }
        }
        return maxSum;
    }

    // 直接对二维数组进行排序
    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        int len = boxTypes.length;
        Arrays.sort(boxTypes,(o1,o2) -> o2[1]-o1[1]); //使用lamdba表达式重写匿名函数.

        int maxSum = 0;
        for(int i = 0 ; i< len ;i ++){
            if(truckSize <=0){
                break;
            }
            int tmpNum = boxTypes[i][0];
            int value = boxTypes[i][1];
            if(truckSize - tmpNum <= 0){
                maxSum += truckSize * value;
                truckSize = 0;
            }else{
                maxSum += tmpNum * value;
                truckSize -= tmpNum;
            }
        }
        return maxSum;
    }
}
