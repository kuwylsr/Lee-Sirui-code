#include<iostream>
#include<unordered_set>
using namespace std;

class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int sum = 0;
        unordered_set<char> set;
        for(char j : J){
            set.insert(j);
        }
        for(char s : S){
            if(set.count(s)>0){
                sum += 1;
            }
        }
        return sum;
    }
};

int main(){

    string J = "aA";
    string S = "aAAbbbb";
    Solution *So = new Solution();
    int sum = So->numJewelsInStones(J, S);
    cout << sum << endl;
    return 0;
}