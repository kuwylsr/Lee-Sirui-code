import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	// @Override
	// public int hashCode(){
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + val;
	// return result;
	// }

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject.getClass() == getClass()) {
			ListNode other = (ListNode) otherObject;
			if (this.val == other.val) {

				return true;
			}
		}
		return false;
	}
}


public class testJ {

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
                    }else{
                       isVisited[i][j] = false;
                       continue; 
                    }
                }        
            }
        }
        return false;
    }

    private boolean backTrace(char[][] board, char[] clist, int index, int row, int col, boolean[][] isVisited){
        int m = board.length;
        int n = board[0].length;

        if(index == clist.length){
            return true;
        }

        int[] direct = {1,2,3,4}; //上下左右
        int row_tmp = row;
        int col_tmp = col;
        for(int i = 0 ; i< 4 ;i++){
            if(direct[i] == 1){
                col -= 1;
            }else if(direct[i] == 2){
                col += 1;
            }else if(direct[i] == 3){
                row -= 1;
            }else if(direct[i] == 4){
                row += 1;
            }
            if(row < 0 || col < 0 || row > m-1 || col > n-1){
                continue;
            }

            if(board[row][col] == clist[index]){
                isVisited[row][col] = true;
                if(backTrace(board, clist, index+1, row, col, isVisited)){
                    return true;
                }
            }else{
                // 回溯
                isVisited[row][col] = false;
				row = row_tmp;
				col = col_tmp;
            }
        }
        return false;
	}


    //------------------------------------------
    

	public static void main(String[] args) {
		testJ t = new testJ();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		boolean res = t.exist(board, word);
		System.out.println(res);

	}

}
