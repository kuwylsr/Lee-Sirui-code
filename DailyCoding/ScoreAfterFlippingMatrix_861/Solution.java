package ScoreAfterFlippingMatrix_861;

public class Solution {
    public int matrixScore(int[][] A) {

        // 第一步，先将矩阵的第一列全部变为1
        for(int i = 0; i < A.length;i ++){
            if(A[i][0] != 1){ //如果第一列不为1，则进行翻转
                for(int j = 0;j<A[i].length; j++){
                    A[i][j] = (A[i][j] == 0) ? 1 : 0;
                }
            }
        }

        // 第二步，将矩阵的所有列都变为1的个数大于0的个数
        for(int j = 1 ; j < A[0].length ;j++){
            int count = 0; //统计0出现的次数
            for(int i = 0 ; i < A.length; i++){
                if(A[i][j] == 0){
                    count ++;
                }
            }
            if(count > Math.floor(A.length / 2)){ //如果0出现的个数大于一半，则进行翻转
                for(int i = 0;i<A.length;i++){
                    A[i][j] = (A[i][j] == 0) ? 1 : 0;
                }
            }
        }

        //计算矩阵的结果
        int sum = 0;
        for(int i = 0;i < A.length; i++){
            int num = 0;
            for(int j = 0 ;j <A[i].length; j++){
                num += A[i][j] * Math.pow(2,(A[i].length - j - 1));
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(11);
    }
}
