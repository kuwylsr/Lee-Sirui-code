#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    //回溯法
    bool isMatch1(string s, string p)
    {
        //每次递归匹配一个字符
        //递归终止条件
        if (p.empty())
            return s.empty(); // 当模式串p为空时，目标串也为空

        bool firstCharMatch = (!s.empty()) && ((s[0] == p[0]) || (p[0] == '.')); //匹配第一个字符

        // 当出现'*'时，就需要使用回溯，因为此时有多种选择的策略，不确定使用哪一种。
        if (p.size() >= 2 && p[1] == '*')
        {                                                       //'*'前面必有一个字符
            return (firstCharMatch && isMatch1(s.substr(1), p)) // 第一种策略，'*'号匹配前面的那一个字符
                   || (isMatch1(s, p.substr(2)));               // 第二种策略，'*'号不匹配任何字符
        }
        else
        { //如果模式串中没有'*'，则直接一个字符一个字符地匹配
            return firstCharMatch && isMatch1(s.substr(1), p.substr(1));
        }
    }

    //动态规划(自顶向下)
    vector<vector<int>> memo; //备忘录(全局变量)
    //dp(i,j) 代表 s.substr(i) 和 p.substr(j) 是否匹配
    bool dp(int i, int j, string s, string p)
    {
        bool ans = false;
        if (memo[i][j] != 2)
            return (memo[i][j] == 1); //利用备忘录，来避免多余的计算
        if (j == p.size())
        { // 当模式串p为空时，目标串也为空
            ans = (i == s.size());
            memo[i][j] = ans ? 1 : 0; //备忘录记录当前匹配结果
            return ans;
        }
        bool firstCharMatch = (i < s.size()) && ((s[i] == p[j]) || p[j] == '.'); //匹配第一个字符

        if (j <= p.size() - 2 && p[j + 1] == '*')
        {
            ans = (firstCharMatch && dp(i + 1, j, s, p)) || (dp(i, j + 2, s, p));
        }
        else
        {
            ans = firstCharMatch && dp(i + 1, j + 1, s, p);
        }
        memo[i][j] = ans ? 1 : 0; //备忘录记录当前匹配结果
        return ans;
    }

    bool isMatch2(string s, string p)
    {
        memo.resize(s.size() + 1, vector<int>(p.size() + 1, 2)); //为了用下标来访问备忘录，需要设置备忘录的大小，并为备忘录赋初值（0：代表false，1：代表true，2：代表空值）
        return dp(0, 0, s, p);
    }

    //动态规划(自底向上)
    bool isMatch3(string s, string p)
    {
        // dp[i][j] 表示s的前i个字符和p的前j个字符是否匹配
        vector<vector<int>> dp(s.size() + 1, vector<int>(p.size() + 1, 2)); //s.size()+1 行， p.size()+1 列的二维数组，初始化为2（表示未赋值）
        dp[0][0] = 1;                                                   //当s和p都为空时，为1（表示true）
        //初始化第0行
        for (int j = 1; j < p.size() + 1; j++)
        { 
            int jtemp = j - 1;
            if (p[jtemp] == '*' && dp[0][j - 2] == 1)
            {
                dp[0][j] = 1;
            }
            else
            {
                dp[0][j] = 0;
            }
        }
        //初始化第0列
        for (int i = 1; i < s.size() + 1; i++)
        {
            dp[i][0] = 0; //当p为空，s不为空时，为0（表示false）
        }

        // i和j代表二维数组的下标
        for (int i = 1; i < s.size() + 1; i++)
        {
            for (int j = 1; j < p.size() + 1; j++)
            {
                int itemp = i - 1; //字符串s的下标
                int jtemp = j - 1; //模式串p的下标
                if (s[itemp] == p[jtemp] || p[jtemp] == '.') 
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p[jtemp] == '*')
                {
                    if (s[itemp] != p[jtemp - 1] && p[jtemp - 1] != '.')
                    {
                        dp[i][j] = dp[i][j - 2]; //‘*’不匹配字符
                    }
                    else
                    {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j]; //‘*’匹配一个或多个字符
                    }
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[s.size()][p.size()] == 1 ? true : false;
    }
};

int main()
{
    string s = "af";
    string p = ".*";
    Solution *S = new Solution();
    bool result = S->isMatch3(s, p);
    cout << result << endl;
    return 0;
}