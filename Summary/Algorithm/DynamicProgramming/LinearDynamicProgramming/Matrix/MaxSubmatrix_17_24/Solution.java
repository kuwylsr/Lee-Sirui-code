package Algorithm.DynamicProgramming.LinearDynamicProgramming.Matrix.MaxSubmatrix_17_24;

public class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        // 统计矩阵中每一列的前缀和
        int[][] preSumList = new int[M+1][N];
        for(int j = 0 ; j < N ;j++){ //初始化每个前缀和数组的一个数(i==0)
            preSumList[0][j] = matrix[0][j];
        }
        for(int i = 1 ; i < M ;i++){ 
            for(int j = 0 ; j < N ;j++){
                preSumList[i][j] = preSumList[i-1][j] + matrix[i][j];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int[] result = new int[4];
        //用双指针遍历所有可能的行对(确定目标矩阵的高)
        for(int i1 = 0 ; i1 < M ;i1 ++){
            for(int i2 = i1 ; i2 < M ;i2++){
                int[] newNumList = new int[N]; // 最大连续子数组和 的输入
                for(int j = 0; j < N ; j++){ //填入前缀和, 压缩为一位数组
                    newNumList[j] = (i1-1 < 0) ? preSumList[i2][j] : preSumList[i2][j] - preSumList[i1-1][j];
                }
                
                // 对一位数组 newNumList 执行最大连续子数组和的算法,计算该高度下矩阵(不同宽度)的最大和.
                int[] dp = new int[N];
                dp[0] = newNumList[0];
                if(dp[0] > maxSum){
                    maxSum = dp[0];
                    result = new int[]{i1,0,i2,0};
                }
                int startCol = 0;
                for(int k = 1 ; k < N ;k++){
                    if(dp[k-1] > 0){
                        dp[k] = dp[k-1] + newNumList[k];
                    }else{
                        dp[k] = newNumList[k];
                        startCol = k;
                    }
                    
                    if(dp[k] > maxSum){
                        maxSum = dp[k];
                        result = new int[]{i1,startCol,i2,k};
                    }
                }   
            }
        }
        return result;
    }

    // 第二次独立完成
    public int[] getMaxMatrix2(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        int[][] preSumList = new int[N][M];
        for(int j = 0 ; j < M ;j ++){ //初始化第一行
            preSumList[0][j] = matrix[0][j];
        }
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < M ;j++){
                preSumList[i][j] = preSumList[i-1][j] + matrix[i][j];
            }
        }

        int[] result = new int[]{0,0,0,0};
        int max = Integer.MIN_VALUE;
        for(int len = 1 ; len <= N ;len ++){
            for(int i = 0; i <= N - len ;i++){
                int j = len + i - 1;

                int[] nums = new int[M];
                for(int k = 0 ; k < M ;k++){
                    nums[k] = i == 0 ? preSumList[j][k] : preSumList[j][k] - preSumList[i-1][k];
                }

                int[] dp = new int[M];
                dp[0] = nums[0];
                max = Math.max(max,nums[0]);
                int start_col = 0;
                for(int t = 1 ; t < M ;t++){
                    if(dp[t-1] >= 0){
                        dp[t] = dp[t-1] + nums[t];
                    }else{
                        dp[t] = nums[t];
                        start_col = t;
                    }
                    if(dp[t] > max){
                        result[0] = i;
                        result[1] = start_col;
                        result[2] = j;
                        result[3] = t;
                        max = dp[t];
                    }
                }
            }
        }
        return result;
    }
}
