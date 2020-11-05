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
    public int numWays(int n) {
        plan_num = 0;
        int[] pace = {1,2};
        backTrace(n,pace,0);
        int ans = (int)(plan_num % (1e9 + 7));
        return ans;
    }

    
    public static void main(String[] args) {
        Solution S = new Solution();
        int ans = S.numWays(7);
        System.out.println(ans);
    }
}
