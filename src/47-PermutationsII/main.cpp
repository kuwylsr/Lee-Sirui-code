#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution{
public:

    void Recursion(vector<int>& nums, vector<vector<int>>& result, vector<int>& tmpV, vector<bool>& isVisited){
        if(tmpV.size() == nums.size()){
            result.push_back(tmpV);
            return ;
        }
        for(int i=0; i<nums.size(); i++){
            if(!isVisited[i]){
                if(i > 0 && nums[i] == nums[i - 1] && !isVisited[i-1]){ //进行去重剪枝，保证在同一循环中不能使用两个值一样的元素，并且该元素当前也未被访问
                    continue;   
                }
                tmpV.push_back(nums[i]);
                isVisited[i] = true;
                Recursion(nums,result,tmpV,isVisited);
                isVisited[i] = false;
                tmpV.pop_back();

            }
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums){
        vector<vector<int>> result;
        vector<int> tmpV;
        vector<bool> isVisited(nums.size(),false);
        sort(nums.begin(), nums.end()); //对nums进行排序，方便之后的去重（剪枝）
        Recursion(nums,result,tmpV,isVisited);
        return result;
    }
};

int main(){
    vector<int> nums = {1,1,3};
    Solution * S = new Solution();
    vector<vector<int>> result = S->permuteUnique(nums);
    for(vector<int> v : result){
        for(int num : v){
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}