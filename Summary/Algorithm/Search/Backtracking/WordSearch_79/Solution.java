package Algorithm.Search.Backtracking.WordSearch_79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0){
            return false;
        }
        int n = board[0].length;
        char[] clist = word.toCharArray();
        boolean[][] isVisited = new boolean[m][n];

        int index = 0; //遍历字符串的下标

        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ; j++){
                index = 0;
                if(board[i][j] == clist[index]){ //起点匹配,开始搜索
                    isVisited[i][j] = true;
                    if(backTrace(board, clist, index + 1,i,j,isVisited)){
                        return true;
                    }else{ //起点搜索失败,回溯
                       isVisited[i][j] = false;
                       continue; 
                    }
                }        
            }
        }
        return false;
    }

    /**
     * 
     * @param board 图
     * @param clist 待匹配的字符串的字符数组
     * @param index 当前要匹配的字符的下标
     * @param row 当前所在图中的行
     * @param col 当前所在途中的列
     * @param isVisited 判断字符是否被访问过的数组
     * @return
     */
    private boolean backTrace(char[][] board, char[] clist, int index, int row, int col, boolean[][] isVisited){
        int m = board.length;
        int n = board[0].length;

        if(index == clist.length){
            return true;
        }

        int[] direct = {1,2,3,4}; //上下左右
        for(int i = 0 ; i< 4 ;i++){
            int row_tmp = row;
            int col_tmp = col;
            if(direct[i] == 1){
                row_tmp = row - 1;
            }else if(direct[i] == 2){
                row_tmp = row + 1;
            }else if(direct[i] == 3){
                col_tmp = col - 1;
            }else if(direct[i] == 4){
                col_tmp = col + 1;
            }

            if(row_tmp < 0 || col_tmp < 0 || row_tmp > m-1 || col_tmp > n-1){ //越界
                continue;
            }

            if(isVisited[row_tmp][col_tmp]){ //已访问过
                continue;
            }

            if(board[row_tmp][col_tmp] == clist[index]){
                isVisited[row_tmp][col_tmp] = true;
                if(backTrace(board, clist, index+1, row_tmp, col_tmp, isVisited)){ //继续搜索
                    return true;
                }
                // 回溯
                isVisited[row_tmp][col_tmp] = false;
            }
        }
        return false;
    }
}
