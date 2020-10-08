#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL),right(NULL) {}
};

class Solution {
public:
    
    // 个人解法：递归遍历+哈希表存储
    void Recursion(TreeNode* root, unordered_map<int,int>& m){
        if(root != NULL){
            int val = root-> val;
            if(m.count(val) > 0){
                m[val] += 1;
            }else{
                m.insert(make_pair(val,1));
            }
            Recursion(root->left,m);
            Recursion(root->right,m);
        }
    }
    vector<int> findMode(TreeNode* root) {
        vector<int> result;
        unordered_map<int,int> m;
        Recursion(root,m);
        
        int max_num = 0;
        unordered_map<int,int>::iterator iter;
        iter = m.begin();
        while (iter != m.end()){
            if(iter->second > max_num){
                max_num = iter->second;
                result.clear();
                result.push_back(iter->first);
            }else if(iter->second == max_num){
                result.push_back(iter->first);
            }
            iter++;
        }
        return result;
    }


    // 官方题解：Morris中序遍历

    int base; //上一个出现的元素
    int count = 0; //当前元素出现的次数
    int max_num = 0; //当前出现的最大次数
    vector<int> result; //目标结果结合
    
    void update(int x){ // 更新 每个 值 的出现次数，最终结果即为 众数(出现次数最多的元素)
        if(base != x){
            count = 0;
            base = x;
        }
        count += 1;
        if(count == max_num){
            result.push_back(x);
        }else if(count > max_num){
            max_num = count;
            result.clear();
            result.push_back(x);
        }
    }   

    /** 
     * 利用 Morris 法，对二叉搜索树进行中序遍历
     * 注意，对二叉搜索树中序遍历的结果，一定为从小到大的有序数列
     */
    vector<int> findMode2(TreeNode* root){
        TreeNode *cur = root;
        TreeNode *pre = NULL;
        while(cur != NULL){ // 当前节点不为空时，继续遍历(执行)
            if(cur -> left == NULL){ // 首先判断当前节点是否有左子树，若没有左子树，则可以直接访问该节点
                update(cur->val);
                cur = cur -> right;
            }else{ // 如果该节点存在左子树，则(接下面)
                pre = cur -> left;
                while(pre -> right != NULL && pre -> right != cur){ //则找到左子树中的“最右”节点,这个节点也是 cur 的前驱节点
                    pre = pre -> right;
                }
                if(pre -> right == NULL){ // 如果前驱节点的右指针为空，则将其指向 cur 节点
                    pre -> right = cur;
                    cur = cur -> left; // 继续处理左儿子
                }else{ //如果前驱节点不为空，也就是已经指向了 cur 节点，则直接处理 cur 节点，并将指针置为NULL
                    update(cur->val);
                    pre -> right = NULL;
                    cur = cur -> right; // 处理完 cur ，cur指向其右节点，处理右子树
                }
            }
        }
        return result;
    }
};

int main(){
    TreeNode* root = new TreeNode(1);
    TreeNode *r = new TreeNode(2);
    TreeNode *rl = new TreeNode(2);
    root->right = r;
    r->left = rl;

    Solution *S = new Solution();
    vector<int> result = S->findMode2(root);
    for(int i : result){
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
