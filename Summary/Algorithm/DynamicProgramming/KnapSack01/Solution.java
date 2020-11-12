package Algorithm.DynamicProgramming.KnapSack01;

public class Solution {

    // 状态转移方程
    // F(i,C) = max(F(i-1,C), v(i)+F(i-1,C-w(i)))  if C >= w[i]
    // F(i,C) = F(i-1,C)                           else

    // -------------------------------递归算法---------------------------------
    // 递归算法无所谓 自底向上 还是 自顶向下,都可以,这里给出的是自底向上
    private static int solveKS1(int[] w, int[] v, int index, int capacity) {
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        int value1 = solveKS1(w, v, index - 1, capacity); // 第index-1件物品不放入背包时的价值

        int value2 = 0;
        if (w[index] <= capacity) { // 如果第index-1件物品放得进背包
            value2 = v[index] + solveKS1(w, v, index - 1, capacity - w[index]); // 第index-1件物品放入背包时的价值
        }

        return Math.max(value1, value2); // 返回最大值

    }

    public static int knapSack1(int[] w, int[] v, int C) {
        int maxValue = solveKS1(w, v, v.length - 1, C);
        return maxValue;
    }

    // ------------------------------记忆化搜索--------------------------------
    // 记忆化搜索就是在递归的基础上增加一个备忘录memo
    private static int memo[][];

    private static int solveKS2(int[] w, int[] v, int index, int capacity) {
        if (index < 0 || capacity <= 0) {
            return 0;
        }

        if (memo[index][capacity] != 0) {
            return memo[index][capacity];
        }
        int value1 = solveKS2(w, v, index - 1, capacity); // 第index-1件物品不放入背包时的价值

        int value2 = 0;
        if (w[index] <= capacity) { // 如果第index-1件物品放得进背包
            value2 = v[index] + solveKS2(w, v, index - 1, capacity - w[index]); // 第index-1件物品放入背包时的价值
        }

        int maxValue = Math.max(value1, value2);
        memo[index][capacity] = maxValue;
        return maxValue; // 返回最大值

    }

    public static int knapSack2(int[] w, int[] v, int C) {
        memo = new int[v.length][C + 1]; // 初始化备忘录
        int maxValue = solveKS2(w, v, v.length - 1, C);
        return maxValue;
    }

    // ------------------------------动态规划--------------------------------
    // F(i,C) = max(F(i-1,C), v(i)+F(i-1,C-w(i)))  if C >= w[i]
    // F(i,C) = F(i-1,C)                           else

    public static int knapSack3(int[] w, int[] v, int C) {
        int len = v.length;
        int[][] dp = new int[len][C + 1];
        // 初始化二维数组 i = 0 时
        for (int j = 0; j < C + 1; j++) {
            if (j >= w[0]) {
                dp[0][j] = v[0];
            } else {
                dp[0][j] = 0;
            }
        }

        // 根据状态转移方程 继续填写二维数组
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < C + 1; j++) {
                if(j >= w[i]){
                    dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len-1][C];
    }

    public static void main(String[] args) {
        int[] w = { 2, 1, 3, 2 };
        int[] v = { 12, 10, 20, 15 };
        int C = 5;
        System.out.println(knapSack3(w, v, C));
    }
}
