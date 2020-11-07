package JZOffer_10_II;

public class Solution {
    
    int plan_num;

    // 个人解法 : 回溯法 (超时!!!)
    private void backTrace(int n, int[] pace, int sum){
        if(sum == n){
            plan_num++;
            return ;
        }else if(sum > n){
            return;
        }

        for(int p : pace){
            sum += p;
            backTrace(n,pace,sum);
            sum -= p;
        }   
    }
    public int numWays1(int n) {
        plan_num = 0;
        int[] pace = {1,2};
        backTrace(n,pace,0);
        int ans = (int)(plan_num % (1e9 + 7));
        return ans;
    }

    // 动态规划 : 
    public int numWays2(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1 ; i++){
            dp[i] = (int)((dp[i - 1] + dp[i - 2]) % (1e9 + 7));
        }
        int ans = dp[n];
        return ans;
    }

    // 动态规划 : O(1) 空间 
    public int numWays3(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int pre1 = 1;
        int pre2 = 1;
        int sum = 0;
        for (int i = 2; i < n + 1 ; i++){
            sum = (int)((pre1 + pre2)% (1e9 + 7));
            pre1 = pre2;
            pre2 = sum;
        }
        int ans = sum;
        return ans;
    }


    public static void main(String[] args) {
        Solution S = new Solution();
        int ans = S.numWays3(7);
        System.out.println(ans);
    }
}
