package WeeklyContest_221.WhereWillTheBallFall_5210;

public class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for(int num = 0 ; num < n ; num++){ //遍历所有小球
            int flag = 0; //标识小球是否会卡住
            int i = 0;
            int j = num;
            while(i < m && j < n && flag == 0){
                if(grid[i][j] == 1){
                    if(j+1 >= n){ //卡在右墙
                        res[num] = -1;
                        flag = 1;
                    }else if(grid[i][j+1] == -1){ //卡在V
                        res[num] = -1;
                        flag = 1;
                    }else{ //向右下走
                        i++;
                        j++;
                    }
                }else if(grid[i][j] == -1){
                    if(j-1 < 0){ //卡在左墙
                        res[num] = -1;
                        flag = 1;
                    }else if(grid[i][j-1] == 1){ //卡在V
                        res[num] = -1;
                        flag = 1;
                    }else{ //向左下走
                        i++;
                        j--;
                    }
                }
            }
            if(flag == 0){
                res[num] = j;
            }
        }
        return res;
    }
}
