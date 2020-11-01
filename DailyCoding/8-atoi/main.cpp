#include <iostream>
#include <limits.h>

using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        int result = 0;
        int nonzero = 0; //标示是否已经跨过了字符串首部的所有空白字符
        int flag = 1; //标示数字是正还是负
        int i = 0;
        //跳过前面所有的空白字符
        for(;i<str.size();i++){
            if(str[i] != ' ') break;
        }
        //判断数字的符号
        if(str[i] == '-') flag = 0;
        if(str[i] == '+' || str[i] == '-') i++;
        for(;i < str.size() ;i++){
            if(!isdigit(str[i])) break;
            int temp = str[i] - '0';
            //判断是否溢出int型整数范围
            if(result > INT_MAX/10 || (result == INT_MAX/10 && temp > 7)){ //利用了超出上限便会变为最小值的原理,就不用再分正负数的情况讨论
                return flag == 1 ? INT_MAX : INT_MIN;
            }
            result = result * 10 + temp;
        }
        return flag == 1 ? result : -result;
    }
};

int main(){
    Solution *S = new Solution();
    string str = "  -91283472332";
    int result = S->myAtoi(str);
    cout << result << endl;
    return 0;
}