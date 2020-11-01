#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
	public:
		//暴力枚举(Brute Force)
		string longestPalindrome1(string s){
			int len = s.size();
			int maxlen = 0;
			string maxPalindromeSub = "";
			for(int start_idx = 0 ; start_idx <= len - 1 ; start_idx++){
				int sublen; //遍历的子串的长度
				//遍历所有下标为start_idx的子串，注意子串要大于maxlen
				for(sublen = 1 + maxlen ; sublen <= s.size()-start_idx ; sublen++){
					string subs = s.substr(start_idx , sublen);
					if(isPalindromicString(subs)){
						maxlen = subs.size();
						maxPalindromeSub = subs;
					}
				}
			}
			return maxPalindromeSub;
		}
		bool isPalindromicString(string subs){
			int i = 0;
			int j = subs.size()-1;
			for(char c : subs){
				if(i > j) break;
				if(subs[i] != subs[j]){
					return false;
				}
				i++;
				j--;
			}
			return true;
		}

		//转化为最长公共子串问题，转而用动态规划求解
		string longestPalindrome2(string s){
			if(s == "") return "";
			string anti_s = s;
			reverse(anti_s.begin(),anti_s.end()); //反转字符串s
			int len = s.size();
			int maxlen = 0;
			int max_idx = 0;
			//申请动态二维数组，并初始化为0
			//int test[len][len] = {};   false!!
			vector<int> temp(len,0);
			vector<vector<int>> arr(len,temp);
			//按行更新
			for(int i = 0 ; i < len ; i++){
				for(int j = 0 ; j < len ; j++){
					//求解arr中的每个元素
					if(s[i] == anti_s[j]){
						if((i==0 || j==0)&&(s[i] == anti_s[j])){
							arr[i][j] = 1;
						}else{
							arr[i][j] = arr[i-1][j-1] + 1;
						}
					}else{
						arr[i][j] = 0;
					}
					//判断下标是否匹配，以及是否需要更新maxlen
					if(arr[i][j] > maxlen){
						int beforeRev = len - 1 - j; //下标倒置前的位置
						if(i - beforeRev + 1 == arr[i][j]){ //**判断下标是否匹配**
							maxlen = arr[i][j];
							max_idx = i; //记录回文的最后的字符下标
						}
					}
				}
			}
			return s.substr(max_idx-maxlen+1,maxlen);
		}

		//经典解决方案：直接动态规划求解
		string longestPalindrome3(string s){
			int len = s.size();
			if(len == 0) return "";
			vector<bool> temp(len,false);
			vector<vector<bool>> arr(len,temp);
			int maxlen = 0;
			int max_i = 0;
			//int max_j = 0;
			//初始化状态
			for(int i = 0 ; i < len ; i++){
				arr[i][i] = true; //单个字符都为回文
				if((i < len - 1)&&(s[i] == s[i+1])){ //两个相同的字符是回文
					arr[i][i+1] = true;
				}
			}
			//也可以按照字符串长度进行遍历
			//按对角顺序更新(由于我们首先知道了 i+1 才会知道 i ，所以倒着遍历就行了)
			for(int i = len - 1 ; i >= 0 ; i--){
				for(int j = i ; j < len ; j++){ // j 要大于等于 i
					int templen = j - i + 1; //子串长度
					// if(templen <= 2){ //子串长度小于等于2，初始化
					// 	string subs = s.substr(i,templen);
					// 	if(isPalindromicString(subs)){
					// 		arr[i][j] = true;
					// 	}
					// }else{
					// 	if(s[i]==s[j]){
					// 		arr[i][j] = arr[i+1][j-1];
					// 	}
					// }
					if((templen > 2)&&s[i]==s[j]){
						arr[i][j] = arr[i+1][j-1];
					}
					//更新最长回文
					if(arr[i][j] == true && templen > maxlen){ 
						maxlen = templen;
						max_i = i;
						//max_j = j;
					}
				}
			}
			return s.substr(max_i,maxlen);
		}

		//中心扩散法
		string longestPalindrome4(string s){
			
		}

};

int main(){

	Solution* S = new Solution();
	string s = "abccbe";
	cout << S->longestPalindrome3(s) << endl;
	return 0;
}