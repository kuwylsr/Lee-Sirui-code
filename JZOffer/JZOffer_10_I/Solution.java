package JZOffer_10_I;


public class Solution {

    // 个人方法: 递归
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(1)
    public int fib1(int n) {
        // 递归终止条件
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int ans = fib1(n - 1) + fib1(n - 2);
            return (int) (ans % (1e9 + 7));
        }
    }

    // 递归 + 备忘录
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    private static int[] memo = new int[100];

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int first, second;
            if (memo[n - 1] != 0) {
                first = memo[n - 1];
            } else {
                first = fib2(n - 1);
                memo[n - 1] = first;
            }

            if (memo[n - 2] != 0) {
                second = memo[n - 2];
            } else {
                second = fib2(n - 2);
                memo[n - 2] = second;
            }
            int ans = first + second;

            return (int) (ans % (1e9 + 7));
        }
    }

    // 动态规划
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int fib3(int n) {
        int[] dp = new int[n + 1];
        // 初始化dp
        dp[0] = 0;
        if (n + 1 > 1) {
            dp[1] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            dp[i] = (int) ((dp[i - 1] + dp[i - 2]) % (1e9 + 7));
        }

        return dp[n];
    }

    // 动态规划 + 极简空间
    // 时间复杂度: O(N)
    // 空间复杂度: O(1)
    // 因为dp中的每个元素只与它的前两个元素有关,因此只需要用几个变量存储它们即可
    public int fib4(int n) {
        if(n == 0){
            return 0;
        }
        int a = 0; //存储前面的两个值
        int b = 1;
        int ans = 1;
        for(int i = 2;i<n+1;i++){
            ans = (int)((a + b)% (1e9 + 7));
            a = b;
            b = ans;
        }
        return ans;
    }
}
