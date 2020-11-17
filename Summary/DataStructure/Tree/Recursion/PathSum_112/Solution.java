package DataStructure.Tree.Recursion.PathSum_112;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    // 个人解法 : 深度优先搜索
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        sum -= root.val; //局部变量
        if(root.left ==null && root.right ==null){ // 到达叶节点
            if(sum == 0){
                return true;
            }else{
                return false;
            }
        }
        //深搜
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
