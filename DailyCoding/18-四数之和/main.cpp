#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target)
    {
        vector<vector<int>> result;
        if (nums.size() < 4)
            return result;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0 && nums[i] == nums[i - 1]) //根据排序性质去重
                continue;
            int tempTarget1 = target - nums[i];
            for (int j = i + 1; j < nums.size(); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int tempTarget2 = tempTarget1 - nums[j];
                int l = j + 1;
                int r = nums.size() - 1;
                while (l < r) {
                    if (nums[l] + nums[r] > tempTarget2) {
                        r--;
                    } else if (nums[l] + nums[r] < tempTarget2) {
                        l++;
                    } else {
                        vector<int> temp = { nums[i], nums[j], nums[l], nums[r] };
                        result.push_back(temp);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                    }
                }
            }
        }
        return result;
    }
};

int main()
{
    int target = 0;
    vector<int> nums = { 1, 0, -1, 0, -2, 2 };
    Solution* S = new Solution();
    vector<vector<int>> result = S->fourSum(nums, target);
    for (vector<int> temp : result) {
        for (int num : temp) {
            cout << num << ",";
        }
        cout << endl;
    }
    return 0;
}