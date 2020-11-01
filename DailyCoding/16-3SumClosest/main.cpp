#include <iostream>
#include <limits.h>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

struct Node {
    int idx;
    int value;
    Node(int i, int v)
    {
        idx = i;
        value = v;
    }

    friend bool operator<(const Node& a, const Node& b)
    {
        return a.value < b.value;
    }
};

class Solution {
public:
    // 个人解法： 利用最大堆（求Top-k）（错误 X ）
    int threeSumClosest1(vector<int>& nums, int target)
    {
        int result = 0;
        int len = nums.size();
        if (len < 3)
            return 0;
        priority_queue<Node> maxheap; // 定义最大堆
        for (int i = 0; i < 3; i++) { //定义堆的大小为3
            Node n(i, abs(nums[i] - target));
            //Node *n = new Node(i,abs(nums[i] - target));
            maxheap.push(n);
        }
        for (int i = 3; i < len; i++) {
            int top_num = maxheap.top().value;
            int temp = abs(nums[i] - target);
            if (temp < top_num) {
                maxheap.pop();
                Node n(i, temp);
                maxheap.push(n);
            }
        }
        for (int i = 0; i < 3; i++) {
            result += nums[maxheap.top().idx];
            maxheap.pop();
        }
        return result;
    }

    //
    int threeSumClosest2(vector<int>& nums, int target)
    {
        int sum = nums[0] + nums[1] + nums[2];
        sort(nums.begin(), nums.end());

        int l, r;
        for (int i = 0; i < nums.size() - 2; i++) {
            //int tempTarget = target - nums[i];
            l = i + 1;
            r = nums.size() - 1;
            // if (nums[i] + nums[l] >= target) { //剪枝
            //     int tempSum = nums[i] + nums[l] + nums[l + 1];
            //     if (abs(target - tempSum) < abs(target - sum)) {
            //         sum = tempSum;
            //     }
            //     continue;
            // }
            while (l < r) {
                int tempSum = nums[i] + nums[l] + nums[r];
                if (abs(target - tempSum) < abs(target - sum)) {
                    sum = tempSum;
                }
                if (tempSum < target) {
                    l++;
                } else if (tempSum > target) {
                    r--;
                } else {
                    return tempSum;
                }
            }
        }
        return sum;
    }
};

int main()
{
    vector<int> nums = { -1, 2, 1, -4 };
    int target = 1;
    Solution* S = new Solution();
    int result = S->threeSumClosest2(nums, target);
    cout << result << endl;
    return 0;
}