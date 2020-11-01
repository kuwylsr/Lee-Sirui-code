package DailyCoding.N_Queens_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * 回溯算法
     * 
     * @param solution   题目结果
     * @param Q_col      当前的一种解,存储每一行中Queen所在列的下标
     * @param row        当前处理的棋盘的行号
     * @param n          棋盘的总行数
     * @param columns    存储Queen所在的列
     * @param diagonals1 存储Queen所在的(正)对角线; 用i-j的值来表征
     * @param diagonals2 存储Queen所在的(负)对角线; 用i+j的值来表征
     */
    public void backtrace(List<List<String>> solution, int[] Q_col, int row, int n, Set<Integer> columns,
            Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) { // 处理完了所有行(递归终止条件)
            List<String> ans = generateboard(Q_col);
            solution.add(ans);
            return;
        }
        int j;
        for (j = 0; j < n; j++) { // 遍历当前行的所有列
            if (columns.contains(j)) {
                continue;
            } else if (diagonals1.contains(row - j)) {
                continue;
            } else if (diagonals2.contains(row + j)) {
                continue;
            } else {
                Q_col[row] = j;
                // 更新条件
                columns.add(j);
                diagonals1.add(row - j);
                diagonals2.add(row + j);
                backtrace(solution, Q_col, row + 1, n, columns, diagonals1, diagonals2); // 继续深搜
                // 回溯
                Q_col[row] = -1;
                columns.remove(j);
                diagonals1.remove(row - j);
                diagonals2.remove(row + j);
            }
        }
        return;
    }

    /**
     * 生成棋盘
     * 
     * @param Q_col 存储Queen所在列的下标
     * @return List<String>格式的棋盘
     */
    public List<String> generateboard(int[] Q_col) {
        int n = Q_col.length;
        List<String> ans = new ArrayList<String>();
        for(int c : Q_col){
            String tmp = "";
            for(int i = 0; i < n; i++){
                if(i == c){
                    tmp += 'Q';
                }else{
                    tmp += '.';
                }
            }
            ans.add(tmp);
        }
        return ans;
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<List<String>>();
        int[] Q_col = new int[n];
        Arrays.fill(Q_col, -1);
        Set<Integer> columns = new HashSet<Integer>(); // 存储Queen所在的列
        Set<Integer> diagonals1 = new HashSet<Integer>(); // 存储Queen所在的(正)对角线; 用i-j的值来表征
        Set<Integer> diagonals2 = new HashSet<Integer>(); // 存储Queen所在的(负)对角线; 用i+j的值来表征
        backtrace(solution, Q_col, 0, n, columns, diagonals1, diagonals2);
        return solution;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        List<List<String>> ans = S.solveNQueens(4);
        System.out.println(ans.toString());
    }
}
