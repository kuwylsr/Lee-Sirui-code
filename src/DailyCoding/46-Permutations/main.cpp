#include<iostream>
#include <vector>

using namespace std;

class Solution {
public:

    /**
     * nums 为算法输入的数组
     * result 记录最后全排列的结果
     * tmpV 用于存储每一种排列的结果
     * isVisited 用于记录每个元素是否被访问
     **/
    void Recursion(vector<int>& nums, vector<int>& tmpV, vector<bool>& isVisited, vector<vector<int>>& result){
        // 递归终止条件，当所有元素都添加进去之后，递归终止。
        if(tmpV.size() == nums.size()){
            result.push_back(tmpV);
            return ;
        }
        for(int i = 0 ;i< nums.size() ; i++){
            if(!isVisited[i]){ //若该元素没有被访问过
                tmpV.push_back(nums[i]); //加入当前的排列中
                isVisited[i] = true; //设置为已被访问
                Recursion(nums,tmpV,isVisited,result); //继续按深搜索
                
                //当递归到底之后，进行回溯，将当前i对应的元素进行撤销
                isVisited[i] = false;
                tmpV.pop_back();
            }
        }
    }

    vector<vector<int>> permute(vector<int>& nums){
        vector<vector<int>> result;
        vector<int> tmpV;
        vector<bool> isVisited(nums.size(),false);
        Recursion(nums,tmpV,isVisited,result);
        return result;
    }

};

int main(){

    vector<int> nums = {1,2,3};
    Solution * S = new Solution();
    vector<vector<int>> result = S->permute(nums);
    for(vector<int> v : result){
        for(int num : v){
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}