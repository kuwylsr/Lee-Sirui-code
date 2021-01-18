package JZOffer_12;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ;j ++){
                if(backTrace(board, 0, word,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrace(char[][] board, int index, String word, int i, int j){
        int M = board.length;
        int N = board[0].length;
        if(index == word.length()){
            return true;
        }
        if(i > M - 1 || i < 0 || j > N-1 || j< 0){
            return false;
        }
        if(board[i][j] == word.charAt(index)){
            board[i][j] = '*'; //设置为被访问过
            boolean flag = backTrace(board, index + 1, word, i+1,j) || backTrace(board, index + 1, word, i-1,j) || backTrace(board, index + 1, word, i,j+1) || backTrace(board, index + 1, word, i,j-1);
            
            if(!flag){ //四条路都不行, 回溯
                board[i][j] = word.charAt(index);   
            }
            return flag;
        }else{ // 剪枝, 不相等直接返回false
            return false;
        }
    }
}
