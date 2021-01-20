package JZOffer_16;

public class Solution {

    // 递归
    public double myPow(double x, int n) {
        long n1 = n;
        if(n < 0){
            n1 = -n1;
            x = 1/x;
        }
        double res = recursion(x,n1);
        return res;
    }

    public double recursion(double x, long n){
        if(n == 0){
            return 1;
        }

        double tmp = recursion(x, n/2);
        double res;
        if(n % 2 == 0){
            res = tmp * tmp;
        }else{
            res = x * tmp * tmp ;
        }
        
        return res;
    }

    // 迭代
    public double myPow2(double x, int n) {
        if(x == 0){
            return 0;
        }

        long b = n;
        if(n < 0){
            b = -b;
            x= 1/x;
        }
        double res = 1;
        while(b > 0){
            if(b % 2 == 1){
                res = res * x;
            }
            x = x*x;
            b = b / 2;
        }
        return res;
    }

    
}
