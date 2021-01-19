package Algorithm.DynamicProgramming.LinearDynamicProgramming.Matrix.MaxSumOfRectangleNoLargerThanK_363;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int K) {
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
        //用双指针遍历所有可能的行对(确定目标矩阵的高)
        for(int i1 = 0 ; i1 < M ;i1 ++){
            for(int i2 = i1 ; i2 < M ;i2++){
                int[] newNumList = new int[N]; // 最大连续子数组和 的输入
                for(int j = 0; j < N ; j++){ //填入前缀和, 压缩为一位数组
                    newNumList[j] = (i1-1 < 0) ? preSumList[i2][j] : preSumList[i2][j] - preSumList[i1-1][j];
                }
                
                // 只能暴力搜索了, 不能在套用 最大连续子数组和 的方式了....
                for(int start = 0 ; start < N ;start ++){
                    int tmpSum = 0;
                    for(int end = start ; end < N ;end ++){
                        tmpSum += newNumList[end];
                        if(tmpSum > maxSum && tmpSum <= K){
                            maxSum = tmpSum;
                        }
                    }
                }
            }
        }
        return maxSum;
    }
}
