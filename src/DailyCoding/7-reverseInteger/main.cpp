#include <iostream>
#include <stack>
#include <limits.h>

using namespace std;

class Solution {
public:
    // 个人解法
    int reverse1(int x) {
        string s = to_string(x);
        stack<char> st; // 用于翻转的栈
        int flag = 1; // 1表示目标数字为正数，0表示目标数字为负数
        for(char c : s){
            if(c == '-'){
                flag = 0;
            }else{
                st.push(c);
            }
        }
        string result = "";
        if(flag == 0){
            result += "-";
        }
        int ifzero = 1; //判断是否数字0起作用
        while(!st.empty()){
            char c = st.top();
            st.pop();
            if(c == '0' && ifzero == 1){ //去掉翻转之后的0
                continue;
            }else{
                ifzero = 0;
                result += c;
            }
        }
        cout << "result : " + result << endl;
        if(ifzero == 1) return 0; // 只有一个数字0
        try{
             int tmp = stoi(result); 
             return tmp;
        }
        catch(const std::out_of_range& e){ //捕获异常，因为有可能翻转之后的整数超过int的范围，若超过直接返回0
            return 0;
        }
    }

    // 官方参考答案
    int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; //取出个位
            x /= 10; //删除个位
            //正负数的溢出情况
            if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
            if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
};

int main(){
    Solution *S = new Solution();
    int result = S->reverse1(0);
    cout << result << endl;
    return 0;
}