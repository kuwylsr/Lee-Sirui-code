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
    void backtrack(int j, vector<int>& nums, vector<int>& tmpV, vector<vector<int>>& result){
        if(j <= nums.size()){
            result.push_back(tmpV);
        }

        for(int i = j;i< nums.size(); i++){ // 注意这里的 i初始化为j，因为此处结果不一定包含所有集合中的元素
            tmpV.push_back(nums[i]);
            backtrack(i+1,nums,tmpV,result); //这里注意参数赋值为 i+1
            tmpV.pop_back();
        }
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> tmpV;
        vector<vector<int>> result;
        backtrack(0, nums, tmpV, result);
        return result;
    }
};

int main() {
    vector<int> nums = {1,2,3};
    Solution * S = new Solution();
    vector<vector<int>> result = S->subsets(nums);
    for(vector<int> v : result){
        for(int num : v){
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}