#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>
using namespace std;
class Solution
{
public:
    vector<int> twoSum1(vector<int> &nums, int target)
    {
        map<int, int> contentToIndex;
        for (int i = 0; i < nums.size(); i++)
        {
            contentToIndex.insert(pair<int, int>(nums[i], i));
        }
        for (int i = 0; i < nums.size(); i++)
        {
            int num = nums[i];
            if (contentToIndex.count(target - num))
            {
                return {contentToIndex[target - num], i};
            }
        }
        return {0, 0};
    }

    vector<int> twoSum2(vector<int> &nums, int target)
    {
        unordered_map<int, int> contentToIndex;
        for (int i = 0; i < nums.size(); i++)
        {
            contentToIndex.insert(pair<int, int>(nums[i], i));
        }
        for (int i = 0; i < nums.size(); i++)
        {
            int num = nums[i];
            cout << contentToIndex.count(target - num) << endl;
            if (contentToIndex.count(target - num) > 0 && contentToIndex[target - num] != i)
            {
                return {contentToIndex[target - num], i};
            }
        }
        return {0, 0};
    }

    vector<int> twoSum3(vector<int> &nums, int target)
    {
        unordered_map<int, int> dict;
        for (int i = 0; i < nums.size(); i++)
            if (dict.count(target - nums[i]))
                return {dict[target - nums[i]], i};
            else
                dict[nums[i]] = i;
        return {0, 0};
    }
};

int main()
{
    Solution *s = new Solution();
    vector<int> nums = {3, 2, 4};
    int target = 6;
    vector<int> result = s->twoSum3(nums, target);
    for (int r : result)
    {
        cout << r << " ";
    }
    cout << endl;
    cout << "hello world" << endl;
    return 0;
}