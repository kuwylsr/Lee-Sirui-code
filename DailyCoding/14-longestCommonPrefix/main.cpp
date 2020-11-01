#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    // 个人解法
    string longestCommonPrefix1(vector<string> &strs)
    {
        string result = "";
        if(strs.size() == 0) return result;
        for(int j = 0 ; j < strs[0].length() ; j++)
        {   
            for(int i = 0 ; i < strs.size() - 1; i++)
            {
                if(j > strs[i].length() - 1)
                {
                    return result;
                }

                if(strs[i][j] != strs[i+1][j])
                {
                    return result;
                    
                }
            }
            result += strs[0][j];
        }
        return result;
    }

    //参考解法1: 水平扫描法(依次扫描每一行)
    // ................
    //在这里巧妙运用了java库中的 indexof()函数

    //参考解法2：按列扫描，依次扫描每个字符串的一列
    // 个人解法就是参考解法2

    //参考解法3：分治
    //递归函数
    string recursion(vector<string> &strs, int l, int r)
    {
        if(l == r) //(递归树的叶子节点函数的)递归终止条件(分到什么时候结束)
        {
            return strs[l];
        }
        int mid = (l + r) / 2;
        string ls = recursion(strs, l, mid);
        string rs = recursion(strs, mid + 1, r);
        return isCommonPrefix(ls, rs); //(递归树的非叶子节点函数的)递归终止条件(合并叶子函数)

    }
    //简单地计算两个字符串的公共前缀的函数
    string isCommonPrefix(string ls, string rs)
    {
        int shortlen = min(ls.length(), rs.length());
        for(int i = 0; i < shortlen; i++)
        {
            if(ls[i] != rs[i]) return ls.substr(0,i);
        }
        return ls.substr(0,shortlen);
    }
    //主体函数
    string longestCommonPrefix2(vector<string> strs)
    {
        if(strs.size() == 0) return "";
        return recursion(strs, 0, strs.size() - 1);
    }

    //参考解法4：二分查找法
    //个人觉得效率不高
};

int main()
{
    vector<string> strs = {"flower","flow","flight"};
    Solution *S = new Solution();
    string result = S->longestCommonPrefix2(strs);
    cout << result << endl;
    return 0;
}