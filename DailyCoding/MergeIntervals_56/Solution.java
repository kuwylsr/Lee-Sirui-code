package MergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len == 0){
            return null;
        }
        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     public int compare(int[] o1, int[] o2){
        //         return o1[0] - o2[0];
        //     }
        // });
        Arrays.sort(intervals, (o1,o2) -> (o1[0]-o2[0]));

        ArrayList<int[]> res = new ArrayList<int[]>();

        int l = intervals[0][0];
        int r = intervals[0][1];
        res.add(new int[]{l,r});

        for(int i = 1 ; i < len ;i++){
            int tmp_l = intervals[i][0];
            int tmp_r = intervals[i][1];
            if(tmp_l <= r){
                if(tmp_r < r){
                    continue;
                }
                res.remove(res.size()-1);
                res.add(new int[]{l,tmp_r});
                r = tmp_r;
            }else{
                res.add(new int[]{tmp_l,tmp_r});
                l = tmp_l;
                r = tmp_r;
            }
        }
        
        int[][] result = new int[res.size()][2];
        for(int i = 0 ; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
