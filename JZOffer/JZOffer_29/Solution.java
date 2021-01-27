package JZOffer_29;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return new int[0];
        }
        int n = matrix[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[] res = new int[m*n];

        int direction = 0; // 0:右, 1:左, 2:上, 3:下
        int i = 0;
        int j = 0;
        int index = 0;
        while(true){
            // 判断是否遍历完成
            if(i >= m || j >= n || i < 0 || j < 0 || isVisited[i][j]){
                break;
            }

            res[index] = matrix[i][j];
            isVisited[i][j] = true; //设置为被访问过
            index++;

            if(direction == 0){ //右
                if(j+1 >= n || isVisited[i][j+1]){
                    direction = 3; 
                    i++;
                }else{
                    j++;
                }
            }else if(direction == 1){ //左
                if(j-1 < 0 || isVisited[i][j-1]){
                    direction = 2;
                    i--;
                }else{
                    j--;
                }
            }else if(direction == 2){ //上
                if(i-1 < 0 || isVisited[i-1][j]){
                    direction = 0;
                    j++;
                }else{
                    i--;
                }
            }else if(direction == 3){ //下
                if(i+1 >= m || isVisited[i+1][j]){
                    direction = 1;
                    j--;
                }else{
                    i++;
                }
            }
        }
        return res;
    }
}
