package PartitionEqualSubsetSum_416;

public class Solution {

    // 方法一: 动态规划,二维数组
    public boolean canPartitio1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) { // 如果和为奇数 直接返回false
            return false;
        }
        int C = sum / 2;

        boolean[][] dp = new boolean[len][C + 1];
        // 初始化二维数组dp
        for (int j = 0; j < C + 1; j++) {
            if (nums[0] == j) {
                dp[0][j] = true;
            }
        }
        for (int i = 0; i < len; i++) { // 此段初始化可写可不写,写上效率可能会高一些,因为此题动态规划每次只需要上一行的数据
            dp[i][0] = true;
        }

        // 动态规划
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < C + 1; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][C];
    }

    // 方法二 : 压缩空间,使用一维数组进行动态规划
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int C = sum / 2;
        boolean[] dp = new boolean[C + 1];

        // 初始化数组
        //dp[nums[0]] = true;// 为什么
        dp[0] = true;

        // 动态规划 (使用一位数组)
        for (int i = 0; i < len; i++) {
            for (int j = C; j >= 0; --j) {
                if (nums[i] <= j) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {

    }
}
