package JZOffer_13;
import java.util.Arrays;

public class Solution {
    public int movingCount(int m, int n, int k) {
        int sum = 0;
        Boolean[][] visitMatrix = new Boolean[m][n];
        for(int i = 0 ; i < m ;i ++){
            Arrays.fill(visitMatrix[i],false);
        }
        
        visitMatrix[0][0] = true;
        sum ++;

        for(int i = 0 ; i < m ;i ++){
            for(int j = 0; j < n ; j++){
                // 如果该节点能被访问到
                if((i-1>=0 && visitMatrix[i-1][j]) || (j-1>=0 && visitMatrix[i][j-1])){
                    if(calsum(i) + calsum(j) <=k){
                        visitMatrix[i][j] = true;
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }

    private int calsum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

}
