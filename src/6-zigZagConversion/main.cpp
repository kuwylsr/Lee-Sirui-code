#include <iostream>
#include <vector>

using namespace std;

class Solution{
	public:
		// 个人解法
		string convert(string s,int numRows){
			if(numRows == 1) return s;
			vector<vector<char>> resultMatrix;
			resultMatrix.resize(numRows);

			int i = 0;
			int flag = 0; //0表示增加i，1表示减少i
			for(char c : s){
				cout << i << endl;
				resultMatrix[i].push_back(c);
				if(i == numRows - 1){
					flag = 1;
				}else if (i == 0){
					flag = 0;
				}

				if (flag == 0){
					i++;
				}else if(flag == 1){
					i--;
				}
			}

			string result;
			for(vector<char> tmp : resultMatrix){
				for(char c : tmp){
					result += c;
				}
			}
			return result;
		}

		// 参考答案
		string convert2(string s,int numRows){
			if(numRows == 1) return s;
			vector<string> resultMatrix;
			resultMatrix.resize(numRows);

			int i = 0;
			int flag = 0; //0表示增加i，1表示减少i
			for(char c : s){
				//cout << i << endl;
				resultMatrix[i] += c;
				if(i == numRows - 1){
					flag = 1;
				}else if (i == 0){
					flag = 0;
				}

				if (flag == 0){
					i++;
				}else if(flag == 1){
					i--;
				}
			}

			string result;
			for(string tmp : resultMatrix){
				result += tmp;
			}
			return result;
		}
};

int main(){
	string s = "AB";
	Solution *S = new Solution();
	string result = S->convert(s,1);
	cout << result << endl; 
	return 0;
}