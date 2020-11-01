#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:

    // 个人解法
    string intToRoman1(int num) {
        string result = "";
        // unordered_map<int, string> map;
        // map.insert(pair<int, string>(1,"I"));
        // map.insert(pair<int, string>(5,"V"));
        // map.insert(pair<int, string>(10,"X"));
        // map.insert(pair<int, string>(50,"L"));
        // map.insert(pair<int, string>(100,"C"));
        // map.insert(pair<int, string>(500,"D"));
        // map.insert(pair<int, string>(1000,"M"));

        // map.insert(pair<int, string>(4,"IV"));
        // map.insert(pair<int, string>(9,"IX"));
        // map.insert(pair<int, string>(40,"XL"));
        // map.insert(pair<int, string>(90,"XC"));
        // map.insert(pair<int, string>(400,"CD"));
        // map.insert(pair<int, string>(900,"CM"));
        vector<string> romanNum_list = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        vector<int> num_list = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        while(num != 0)
        {
            //cout << index << endl;
            int temp = num_list[index];
            int shang = num / temp;
            if(shang > 0)
            {
                for(int i = shang ; i > 0 ;i--)
                {
                    //result += map[temp];
                    result += romanNum_list[index];
                }
                num -= (temp*shang);
            }
            else
            {
                index++;
            }
        }
        return result;
    }

    // 网友解法
    string intToRoman2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        vector<int> nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        vector<string> romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        string result = "";
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                result += romans[index];
                num -= nums[index];
            }
            index++;
        }
        return result;
    }
};

int main(){
    int num = 1994;
    Solution *S = new Solution();
    string result = S->intToRoman1(num);
    cout << result << endl;
    return 0;
}