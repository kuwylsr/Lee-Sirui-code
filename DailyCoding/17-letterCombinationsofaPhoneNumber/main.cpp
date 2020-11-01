#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> resultList;
    unordered_map<string, string> map = { { "2", "abc" }, { "3", "def" }, { "4", "ghi" }, { "5", "jkl" }, { "6", "mno" }, { "7", "pqrs" }, { "8", "tuv" }, { "9", "wxyz" } };
    void combine(string combineStr, string digits)
    {
        if (digits == "" && combineStr != "") { //递归终止条件
            resultList.push_back(combineStr);
        } else {
            for (char letter : map[digits.substr(0, 1)]) {
                combine(combineStr + letter, digits.substr(1));
            }
        }
    }

    vector<string> letterCombinations(string digits)
    {
        string combineStr = "";
        combine(combineStr, digits);
        return resultList;
    }
};

int main()
{
    string digits = "23";
    Solution* S = new Solution();
    vector<string> result = S->letterCombinations(digits);
    for (string s : result) {
        cout << s << ",";
    }
    cout << endl;
    return 0;
}