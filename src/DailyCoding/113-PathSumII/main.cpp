#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x)
        : val(x)
        , left(NULL)
        , right(NULL)
    {
    }
};

class Solution {
public:
    vector<vector<int>> result;
    vector<int> curPath;

    // 个人解法：采用递归的按深搜索
    int curSum = 0;
    vector<vector<int>> pathSum(TreeNode* root, int sum)
    {
        if (root != NULL) {
            curPath.push_back(root->val);
            int curVal = root->val;
            curSum += curVal;
            if (root->left == NULL && root->right == NULL) { //当为叶子节点时，对当前路径的curSum进行判断
                if (curSum == sum) {
                    result.push_back(curPath);
                }
            }
            pathSum(root->left, sum);
            pathSum(root->right, sum);
            
            curSum -= curVal; //关键：当遍历完目标节点的左右子树后，对该节点的值进行弹出
            curPath.pop_back();
        }
        return result;
    }

    // 尝试改造112题 题解
    vector<vector<int>> pathSum2(TreeNode* root, int sum)
    {
        if (root != NULL) {
            curPath.push_back(root->val);
            if (root->left == NULL && root->right == NULL) {
                if (root->val == sum) {
                    result.push_back(curPath);
                }
            }
            pathSum2(root->left, sum - root->val);
            pathSum2(root->right, sum - root->val);
            curPath.pop_back();
        }
        return result;
    }
    
    // 改造
    // 把递归函数脱离出来，这样可以定义递归函数的返回类型为 void ，就不必每次都返回二维vector
    void dfs(TreeNode* root, int sum){
        if (root != NULL) {
            curPath.push_back(root->val);
            if (root->left == NULL && root->right == NULL) {
                if (root->val == sum) {
                    result.push_back(curPath);
                }
            }
            dfs(root->left, sum - root->val);
            dfs(root->right, sum - root->val);
            curPath.pop_back();
        }
    }

    vector<vector<int>> pathSum3(TreeNode* root, int sum){
        dfs(root,sum);
        return result;
    }
};

int main()
{

    return 0;
}