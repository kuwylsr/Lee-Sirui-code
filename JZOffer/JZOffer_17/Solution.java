package JZOffer_17;

public class Solution {

    // 基础
    public int[] printNumbers(int n) {
        double num = Math.pow(10,n);
        int[] res = new int[(int)num-1];
        for(int i = 1 ; i < num ;i++){
            res[i-1] = i;
        }
        return res;
    }

    // 本题的进阶考法(也是主要的考察内容, 有大数的情况, 需要使用String)
    StringBuilder res;
    String[] nums;
    int w; //当前数字大小的位数(不算前导0)
    int nines; //当前数字中包含9的个数
    public String printNumbers2(int n){
        res = new StringBuilder();
        nums = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        w = 1;
        nines = 0;
        dfs(n,0,new StringBuilder());
        return res.toString();
    }

    /**
     * 
     * @param n 最高位数
     * @param index 当前到了第几位
     * @param tmpResult 当前结果
     */
    private void dfs(int n, int index,StringBuilder tmpResult){
        if(index == n){
            // System.out.println("n-w:" + (n-w) );
            res.append(tmpResult.substring(n-w)).append(","); //不能包含前导0
            if(nines == w){ //如果当前9的个数等于数字的个数, 那么意味着要扩展1位了.
                w++;
            }
            return;
        }
        for(int i = 0 ; i < 10 ;i++){
            tmpResult.append(i);
            if(i == 9){
                nines++;
            }
            dfs(n, index+1, tmpResult);
            // 回溯
            tmpResult.deleteCharAt(tmpResult.length()-1);
        }
        nines--; //遍历完当前位的所有数字时
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String res = solution.printNumbers2(2);
        System.out.println(res);
    }
}
