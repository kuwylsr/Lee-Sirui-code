#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    // 个人解法
    int maxArea1(vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;
        int maxArea = 0;
        int minHeight = 0; //当前的最大面积下的最小高度
        int tempHeight = 1; //移动指针之后的高度
        int tempi; //minHeight对应的指针i
        while(i < j)
        {
            cout << "i:" + to_string(i) << endl;
            cout << "j:" + to_string(j) << endl;
            cout << "minHeight:" + to_string(minHeight) << endl;
            //首先判断更新之后的最小height是否比之前的大
            if(tempHeight > minHeight)
            {
                minHeight = min(height[i], height[j]); //求出当前最小高度
                int tempArea = (j-i) * minHeight; // 计算当前面积
                tempi = i;
                if(tempArea > maxArea) // 更新
                {
                    maxArea = tempArea;
                }
            }
            //更新宽度
            if(minHeight == height[tempi])
            {
                i++;
                tempHeight = height[i];
            }
            else
            {
                j--;
                tempHeight = height[j];
            }
        }
        return maxArea;
    }

    //答案解法
    int maxArea(vector<int>& height) {
        int maxarea = 0, l = 0, r = height.size() - 1;
        while (l < r) {
            maxarea = max(maxarea, min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
};

int main(){

    vector<int> input = {6,4,3,1,4,6,99,62,1,2,6};
    Solution *S = new Solution();
    int result = S->maxArea1(input);
    cout << result << endl;
    return 0;
}
