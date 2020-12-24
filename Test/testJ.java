import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	int i = 0;

	public void dfs(int j) {
		i++;
		if (j == 2) {
			return;
		}
		j++;
		dfs(j);
		System.out.println("1:" + i);
	}


	public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp,0);

        if(len == 1){
            return Integer.parseInt(s.charAt(0)+"") == 0 ? 0:1;
        }
        
        int n1 = Integer.parseInt(s.charAt(0)+"");
        int n2 = Integer.parseInt(s.charAt(1)+"");
        if(n1 == 0){
            return 0;
        }else{
            dp[0] = 1;
            int sum = n1 * 10 +n2;
            if(n2 == 0){
                if(sum >= 1 && sum <= 26){
                    dp[1] = 1;
                }else{
                    dp[1] = 0;
                }
            }else{
                if(sum >= 1 && sum <= 26){
                    dp[1] = 2;
                }else{
                    dp[1] = 1;
                }
            }
        }

        for(int i = 2 ; i< len ;i ++){
            int num1 = Integer.parseInt(s.charAt(i-1)+"");
            int num2 = Integer.parseInt(s.charAt(i)+"");
            int conNum = num1*10+num2;
            if(num1 == 0){
                if(num2 == 0){
                    return 0;
                }else{
                    dp[i] = dp[i-1];
                }
            }else{
                if(num2 == 0){
                    if(conNum >= 1 && conNum <= 26){
                        dp[i] = dp[i-2];
                    }else {
                        return 0;
                    }
                }else{
                   if(conNum >= 1 && conNum <= 26){
                        dp[i] = dp[i-1] + dp[i-2];
                    }else {
                        dp[i] = dp[i-1];
                    } 
                }
            }
        }
        return dp[len-1];
	}
	
	public static void main(String[] args) {
        int[][][] dp = new int[1][1][1];
        dp[0][0][0] = 1;
        System.out.println(dp[0][0][0]);
		
	}

}
