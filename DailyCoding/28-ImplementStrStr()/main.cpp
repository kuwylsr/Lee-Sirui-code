#include <iostream>
#include <string>
#include <cstring>

using namespace std;

class Solution {
public:
    // 参考解法一：子串逐一比较，线性复杂度
    int strStr(string haystack, string needle) {

        int needle_len = strlen(needle.c_str());
        int haystack_len = strlen(haystack.c_str());
        if(haystack_len < needle_len){
            return -1;
        }
        for(int i = 0 ; i < haystack_len - needle_len + 1 ; i++){ //注意当haystack剩余字符串长度小鱼needle时，则不需要在进行比较
            string sub = haystack.substr(i,needle_len);
            cout << sub << endl;
            // // 手动判断两个字符串是否相等
            // bool flag = true;
            // for(int j = 0 ;j < strlen(sub.c_str()) ; j++){
            //     if (needle[j] != sub[j]){
            //         flag = false;
            //         break;
            //     }
            // }
            // if (flag == true){
            //     return i;
            // }
            if (sub == needle){
                return i;
            }
        }
        return -1;
    }

    // 参考解法二： 双指针，线性复杂度
    int strStr2(string haystack, string needle){
        int haystack_len = strlen(haystack.c_str());
        int needle_len = strlen(needle.c_str());
        int point_h = 0; //第一个“指针”来遍历haystack
        if(needle_len == 0) return 0;
        if(haystack_len < needle_len){
            return -1;
        }
        while(point_h < haystack_len - needle_len + 1){
            int point_n = 0;
            // 当第一个字符相等时，开始进行逐一匹配
            int max_len = 0;
            while(haystack[point_h] == needle[point_n] && point_n < needle_len){
                point_n++;
                point_h++;
                max_len ++;
            }
            if(max_len == needle_len){
                return (point_h - max_len);
            }else{
                point_h = point_h - max_len + 1;
            }
        }
        return -1;
    }
};

int main() {
    string haystack = "hello";
    string needle = "ll";
    Solution * S = new Solution();
    int result = S ->strStr2(haystack,needle);
    cout << result << endl;
    return 0;
}