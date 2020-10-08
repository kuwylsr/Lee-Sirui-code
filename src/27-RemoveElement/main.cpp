#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    // 个人解法
    int removeElement(vector<int>& nums, int val) {
        if(nums.size() == 0){
            return 0;
        }
        int new_len = 0;
        for(int i = 0 ;i < nums.size() ; i ++){
            int tmp = nums[i];
            if(tmp != val){
                nums[new_len] = tmp;
                new_len += 1;
            }
        }
        return new_len;
    }
};

int main() {

    vector<int> nums = {0,1,2,2,3,0,4,2};
    int val = 2;
    Solution * S = new Solution();
    int result = S->removeElement(nums,val);
    for(int i = 0; i < result;i++){
        cout << nums[i] << " ";
    }
    cout << endl;
    return 0;
}