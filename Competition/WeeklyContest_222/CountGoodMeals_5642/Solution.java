package WeeklyContest_222.CountGoodMeals_5642;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 哈希表(类似与两数之和)
    public int countPairs(int[] deliciousness) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = deliciousness.length;
        // 初始化map
        for(int i = 0 ; i < len ; i++){
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i],0)+1);
        }

        long count = 0; //一定要用long, 会溢出导致最后结果错误!!
        for(int i = 0 ; i < len ; i++){
            for(int target = 0 ; target < 22 ; target++){
                int targetNum = (int)Math.pow(2,target);
                if(map.containsKey(targetNum - deliciousness[i])){
                    if(targetNum - deliciousness[i] == deliciousness[i]){
                        count += (map.get(targetNum - deliciousness[i])-1);
                    }else{
                        count += map.get(targetNum - deliciousness[i]);
                    }
                }
            }
        }
        System.out.println(count);
        return (int)((count/2)%(1e9 + 7));
    }

    // 哈希表2(类似于两数之和)
    public int countPairs2(int[] deliciousness){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = deliciousness.length;

        long count = 0; //一定要用long, 会溢出导致最后结果错误!!
        for(int i = 0 ; i < len ; i++){
            for(int target = 0 ; target < 22 ; target ++){
                int targetNum = (int)Math.pow(2,target);
                if(map.containsKey(targetNum - deliciousness[i])){
                    count += map.getOrDefault(targetNum - deliciousness[i], 0);
                }
            }
            map.put(deliciousness[i],map.getOrDefault(deliciousness[i], 0)+1);
        }
        return (int)(count%(1e9+7));
    }
}
