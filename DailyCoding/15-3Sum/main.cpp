#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    // 方法一：数组排序 +　哈希表
    vector<vector<int>> threeSum1(vector<int>& nums)
    {
        vector<vector<int>> result;
        //将数组按升序排序
        sort(nums.begin(), nums.end());
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) { //将数组中的 数字的相反数 以及其 对应的下标 存入哈希字典
            map[-nums[i]] = i; //如果有key值相同的，要进行覆盖（因此不能采用insert方法）
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // 根据已排序的性质进行去重1
                continue;
            for (int j = i + 1; j < nums.size(); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) // 根据已排序的性质进行去重2
                    continue;
                if (map.count(nums[i] + nums[j]) > 0) {
                    int target_index = map[nums[i] + nums[j]];
                    if (target_index > j) { // 去重3(保证三个数 nums[i] < nums[j] < target)
                        vector<int> tempv = { nums[i], nums[j], -(nums[i] + nums[j]) };
                        result.push_back(tempv);
                    }
                }
            }
        }
        return result;
    }

    // 方法二：数组排序 + 双指针（剪枝）
    vector<vector<int>> threeSum2(vector<int>& nums)
    {
        vector<vector<int>> result;
        //将数组按升序排序
        sort(nums.begin(), nums.end());
        int l, r; // 定义双指针

        for (int i = 0; i < nums.size(); i++) {
            int target = -nums[i];
            if (nums[i] > 0) //剪枝
                break;
            if (i > 0 && nums[i] == nums[i - 1]) //去重
                continue;
            l = i + 1;
            r = nums.size() - 1;
            while (l < r) {
                int temp = nums[l] + nums[r];
                if (temp == target) {
                    vector<int> tempv = { nums[l], nums[r], -target };
                    result.push_back(tempv);
                    l++;
                    r--;
                    // 去重
                    while ((l < r) && (nums[l] == nums[l - 1]))
                        l++;
                    while ((l < r) && (nums[r] == nums[r + 1]))
                        r--;
                } else if (temp < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
};

int main()
{
    vector<int> nums = { -1, 0, 1, 2, -1, -4 };
    Solution* S = new Solution();
    vector<vector<int>> result = S->threeSum2(nums);

    for (vector<int> tempv : result) {
        for (int num : tempv) {
            cout << num << ",";
        }
        cout << endl;
    }
    return 0;
}