package N_QueensII_52;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    int ans = 0;

    public void backtrace(int row, int n, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row == n){
            ans ++;
            return;
        }

        for(int j = 0; j < n; j++){
            if(columns.contains(j)){
                continue;
            }else if(diagonals1.contains(row - j)){
                continue;
            }else if(diagonals2.contains(row + j)){
                continue;
            }else{
                columns.add(j);
                diagonals1.add(row-j);
                diagonals2.add(row+j);
                backtrace(row+1, n, columns, diagonals1, diagonals2);
                // 回溯
                columns.remove(j);
                diagonals1.remove(row-j);
                diagonals2.remove(row+j);
            }
        }
        return;
    }

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrace(0, n, columns, diagonals1, diagonals2);
        return ans;
    }

    
}
