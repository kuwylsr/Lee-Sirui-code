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
    // 个人解法：采用递归的按深搜索
    int curSum = 0;
    bool flag = false;
    bool hasPathSum(TreeNode* root, int sum)
    {
        if (flag) {
            return true;
        }
        if (root != NULL) {
            int curVal = root->val;
            curSum += curVal;
            cout << curSum << "  ";
            hasPathSum(root->left, sum);
            hasPathSum(root->right, sum);
            if (root->left == NULL && root->right == NULL) { //当为叶子节点时，对当前路径的curSum进行判断
                flag = (curSum == sum);
            }
            curSum -= curVal; //关键：当遍历完目标节点的左右子树后，对该节点的值进行弹出
        }
        return flag;
    }

    // 同样采用递归的写法，但更为直观
    // 递归的思想为，假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val
    // 其换了一种思维方式，不是让 路径上的值累和==sum，而是每遍历一个点，都让sum-val，最后判断叶节点是否等于当前sum即可。
    bool hasPathSum2(TreeNode* root, int sum)
    {
        if (root == NULL) {
            return false;
        }
        if (root->left == NULL && root->right == NULL) {
            return root->val == sum;
        }
        return hasPathSum2(root->left, sum - root->val) || hasPathSum2(root->right, sum - root->val);
    }
};

int main()
{

    return 0;
}