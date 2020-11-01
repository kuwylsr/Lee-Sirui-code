#include <iostream>
#include <unordered_set>
#include <map>
using namespace std;

class Solution{
    public:
        // 个人解法(暴力解法,仅用了hashset进行优化)
        int lengthOfLongestSubstring1(string s) {
            if(s.size() == 0) return 0;
            int start_idx = 0;
            int cur_max = 0;
            int pre_max = 0;
            int flag = 0;
            unordered_set<char> subSet;
            while(start_idx < s.size()){ //从前到后遍历所有子串
                for(char c : s.substr(start_idx,s.size()-start_idx)){ //遍历子串的每个字符
                    if(!subSet.count(c)){ //如果没有出现过,就加入hashset
                        subSet.insert(c);
                        cur_max++;
                    }else{ //如果出现过,记录max,遍历下一个子串
                        flag = 1;
                        break;
                    }
                }
                if(cur_max > pre_max){ //记录最大子串
                    pre_max = cur_max;
                }
                if(flag == 0) return pre_max; //如果该子串已经访问到最后了,就直接输出当前最大max

                start_idx++;
                cur_max = 0;
                subSet.clear();
                flag = 0;
            }
            return pre_max;
        }
        // 答案解法1(滑动窗口)
        int lengthOfLongestSubstring2(string s) {
            int n = s.size();
            unordered_set<char> set;
            int ans = 0;
            int i = 0;
            int j = 0;
            while(i < n && j < n){
                if(!set.count(s[j])){
                    set.insert(s[j++]);
                    ans = max(ans,j-i);
                }else{ // 当窗口内字符与到达字符冲突时,左边界不断右移,直到满足要求(而不是从新的左边界开始,从头遍历字符串(暴力解法))
                    set.erase(s[i++]);
                }
            }
            return ans;
        }
        // 答案解法2
        int lengthOfLongestSubstring3(string s){
            int n = s.size();
            map<char,int> charToIndex;
            int ans = 0;
            int i = 0;
            int j = 0;
            while(i < n && j < n){
                if(charToIndex.count(s[j])){ //若到达的字符与窗口内字符有冲突
                    i = max(charToIndex[s[j]]+1 , i); //左边界直接移动到冲突字符的右侧
                }
                ans = max(ans,(j-i+1));
                charToIndex[s[j]] = j; //insert方式插入数据，重复的key会直接被放弃，而不是进行覆盖（这一点与Java不同）
                j++;
            }
            return ans;
        }
        // 答案解法3
        int lengthOfLongestSubstring4(string s){
            int n = s.size();
            int ans = 0;
            int index[128]={}; // current index of character
            for(int j = 0 , i = 0 ; j < n ; j++){
                i = max(index[s[j]], i);
                ans = max(ans,(j-i+1));
                index[s[j]] = j+1;
            }
            return ans;
        }
};



int main(){
    string str = "abcabcbb";
    Solution* s = new Solution();
    int result = s->lengthOfLongestSubstring3(str);
    cout << result << endl;
    return 0;
}