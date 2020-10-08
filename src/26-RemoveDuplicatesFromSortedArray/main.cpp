#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:

    // 个人解法：
    int removeDuplicates(vector<int>& nums){
        if (nums.size() == 0){
            return 0;
        }
        int new_len = 1; // 默认第一个元素肯定在结果数组中
        int pre_num = nums[0];
        for(int i = 1 ; i< nums.size() ; i++){
            int tmp = nums[i];
            if (tmp != pre_num){
                nums[new_len] = tmp;
                new_len += 1;
                pre_num = tmp;
            }else{
                continue;
            }
        }
        return new_len;
    }
};

int main(){
    vector<int> nums = {0,0,1,1,1,2,2,3,3,4};
    Solution *S = new Solution();
    int result = S->removeDuplicates(nums);
    cout << result << endl;
    for (int i = 0; i < result; i++) {
        cout << nums[i] << " ";
    }
    cout << endl;
    return 0;
}