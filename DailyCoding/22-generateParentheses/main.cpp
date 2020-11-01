#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    // 回溯法（深度搜索）(暴力法)
    vector<string> generateParenthesis1(int n)
    {
        vector<string> result;
        string tempString = ""; //目前形成的括号字符串
        generateAll(tempString, 2 * n, result); //调用递归函数
        return result;
    }

    // 递归函数
    // 整体来说，就是一个深度搜索解空间树的过程
    // 注意只有 result参数是传地址（即使用的都是同一个内存空间的变量）； 而 tempString 是复制一份传入参数
    void generateAll(string tempString, int size, vector<string>& result)
    {
        if (size == tempString.length()) {
            if (isVaild(tempString)) { //递归函数终止条件(开始回溯)
                result.push_back(tempString);
            }
        } else {
            tempString += '('; //每次向下递归，都先加'('
            generateAll(tempString, size, result);

            tempString[tempString.size() - 1] = ')'; // （回溯）将当前字符串的最后一个符号'('替换成')'
            generateAll(tempString, size, result);
        }
    }

    // 判断当前括号字符串是否有效（tempString是否有效）
    bool isVaild(string s)
    {
        int count = 0;
        for (char c : s) {
            if (c == '(')
                count++;
            else
                count--;
            if (count < 0)
                return false;
        }
        return (count == 0);
    }
    // ------------------------------------------------------------------------------------------------------
    // 回溯法（深度搜索）+ 剪枝
    vector<string> generateParenthesis2(int n)
    {
        vector<string> result;
        string tempString = ""; //目前形成的括号字符串
        generateAll2(tempString, 2 * n, 0, 0, result); //调用递归函数
        return result;
    }

    // 递归函数，注意剪枝
    void generateAll2(string tempString, int size, int open, int close, vector<string>& result)
    {
        if (size == tempString.length()) {
            result.push_back(tempString);
        }

        //有条件的放置 '(' 和 ')' （相当于在方法一暴力回溯的基础上进行剪枝）
        if(open < size/2){
            generateAll2(tempString + '(', size, open+1, close, result);
        }
        if(close < open){
            generateAll2(tempString + ')', size, open, close+1, result);
        }
    }
};

int main()
{
    int n = 3;
    Solution* s = new Solution();
    vector<string> result = s->generateParenthesis2(n);
    for (string s : result) {
        cout << s << ",";
    }
    cout << endl;
    return 0;
}
