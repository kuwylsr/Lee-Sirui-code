package WeeklyContest_220.JumpGameVI_1696;

import java.util.PriorityQueue;

public class Solution {
    
    
    // 个人解法 : 动态规划(超时)
    // 时间复杂度: O(N^2)
    // 空间复杂度 : O(N)
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for(int i = 1 ; i < len ;i ++){
            int tmp_max = Integer.MIN_VALUE;
            int low = (i-k) < 0? 0 : (i-k);
            for(int j = low ; j <= i-1 ;j++){
                tmp_max = Math.max(tmp_max, dp[j]);
            }
            dp[i] = tmp_max + nums[i];
        }
        return dp[len-1];
    }

    // 动态规划 + 优先队列(堆)优化
    // 时间复杂度 : O(NlogN)
    // 空间复杂度 : O(N)
    public int maxResult2(int[] nums, int k){
        int len = nums.length;
        int[] dp = new int[len];

        // PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
        // 	@Override
        // 	public int compare(int[] o1, int[] o2) {
        // 		return o1[0] - o2[0];
        // 	}
        // });
        
        // 使用lamdba表达式对匿名内部类函数进行重写
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[0]-o2[0]);
        
        q.add(new int[]{nums[0],0});
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            // 维护从当前i开始, 找到第一个满足要求的对首元素(如果不满足,直接出队)
            while(i - q.peek()[1] > k){
                q.poll();
            }

            dp[i] = q.peek()[0] + nums[i];
            q.add(new int[]{dp[i],i});
        }
        return dp[len - 1];
    }

}
