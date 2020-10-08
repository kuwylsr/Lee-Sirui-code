#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /**
     * j 用于控制遍历 nums 数组的位置，因为此问题不需要每次都遍历所有的 nums 数组
     * nums 为算法输入的数组
     * result 记录最后全排列的结果
     * tmpV 用于存储每一种排列的结果
     **/
    void backtrack(int j, vector<int>& nums, vector<int>& tmpV, vector<vector<int>>& result)
    {
        if (j <= nums.size()) {
            result.push_back(tmpV);
        }
        // 此处不需要 isVisited ，因为每次循环初始化 i = j
        for (int i = j; i < nums.size(); i++) {
            if (i > j && nums[i] == nums[i - 1]) { //去重(保证在同一循环中，不能连续出现两个值一样的元素)
                continue;
            }
            tmpV.push_back(nums[i]);
            backtrack(i + 1, nums, tmpV, result);
            tmpV.pop_back();
        }
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums)
    {
        vector<vector<int>> result;
        vector<int> tmpV;
        sort(nums.begin(), nums.end()); //对 nums 进行排序，方便去重
        backtrack(0, nums, tmpV, result);
        return result;
    }
};

int main()
{
    vector<int> nums = { 1, 2, 2 };
    Solution* S = new Solution();
    vector<vector<int>> result = S->subsetsWithDup(nums);
    for (vector<int> v : result) {
        for (int num : v) {
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}