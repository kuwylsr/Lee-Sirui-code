#include <iostream>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    // 个人解法
    int romanToInt1(string s)
    {
        int result = 0;
        string curs = "";
        unordered_map<string, int> map = {{"I", 1}, {"V", 5}, {"X", 10}, {"L", 50}, {"C", 100}, {"D", 500}, {"M", 1000}, {"IV", 4}, {"IX", 9}, {"XL", 40}, {"XC", 90}, {"CD", 400}, {"CM", 900}};
        for(char c : s)
        {   
            string temps = curs;
            curs += c;
            if(map.count(curs) == 0) //若没有找到相应的罗马数字，则将前一个罗马数字进行识别
            {
                result += map[temps];
                curs = c;
            }
        }
        result += map[curs]; //识别最后一个罗马数字
        return result;
    }

    // 网友1的高效解法
    int romanToInt2(string s)
    {
        unordered_map<string, int> m = {{"I", 1}, {"IV", 3}, {"IX", 8}, {"V", 5}, {"X", 10}, {"XL", 30}, {"XC", 80}, {"L", 50}, {"C", 100}, {"CD", 300}, {"CM", 800}, {"D", 500}, {"M", 1000}};
        int r = m[s.substr(0, 1)];
        for(int i=1; i<s.size(); ++i){
            string two = s.substr(i-1, 2);
            string one = s.substr(i, 1);
            r += m[two] ? m[two] : m[one];
        }
        return r;
    }

    // 网友2的高效解法
    int romanToInt3(string s)
    {
        int result = 0;
        unordered_map<char, int> roman_num_map = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        int size = s.size();
        for(int i = 0; i < size; ++i)
        {
            //小的数字位于大的数字左边
            if(roman_num_map[s[i]] < roman_num_map[s[i + 1]])
            {
                result -= roman_num_map[s[i]];
            }
            else
            {
                 result += roman_num_map[s[i]];
            }
        }
        return result;
    }
    
};

int main()
{
    string s = "MCMXCIV";
    Solution *S = new Solution();
    int result = S->romanToInt3(s);
    cout << result << endl;
    return 0;
}