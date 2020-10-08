#include <iostream>
#include <stack>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    // 个人解法
    bool isValid1(string s)
    {
        if (s.size() == 0)
            return true;
        stack<char> st;
        for (char c : s) {
            //如果当前符号与栈顶匹配就删除栈顶元素，不匹配就压入当前符号
            if (!st.empty()) {
                char topc = st.top();
                if ((topc == '(' && c == ')') || (topc == '[' && c == ']') || (topc == '{' && c == '}')) {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                st.push(c);
            }
        }
        if (st.empty()) {
            return true;
        } else {
            return false;
        }
    }

    // 官方解法
    bool isValid2(string s)
    {
        if (s.size() == 0)
            return true;
        unordered_map<char, char> map = { { ')', '(' }, { '}', '{' }, { ']', '[' } };
        stack<char> st;
        for(char c : s){
            if(map.count(c) > 0){ //如果为右括号，则必须与当前栈顶符号匹配，否则false
                char top = st.empty() ? '#' : st.top();
                if(top != map[c]){
                    return false;
                }else{
                    st.pop();
                }
            }else{ //如果为左括号，直接压栈
                st.push(c);
            }
        }
        //栈为空时，为true，否则为false
        if (st.empty()) {
            return true;
        } else {
            return false;
        }
    }

    // 网友解法（用vector实现栈）
    bool isValid3(string s)
    {
        if (s.size() == 0)
            return true;
        unordered_map<char, char> map = { { ')', '(' }, { '}', '{' }, { ']', '[' } };
        vector<char> vecStack;
        for(char c : s){
            if(map.count(c) > 0){ //如果为右括号，则必须与当前栈顶符号匹配，否则false
                char top = vecStack.empty() ? '#' : vecStack[vecStack.size()-1];
                if(top != map[c]){
                    return false;
                }else{
                    vecStack.pop_back();
                }
            }else{ //如果为左括号，直接压栈
                vecStack.push_back(c);
            }
        }
        //栈为空时，为true，否则为false
        if (vecStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
};

int main()
{
    string s = "({[(]})";
    Solution* S = new Solution();
    bool result = S->isValid3(s);
    cout << result << endl;
    return 0;
}