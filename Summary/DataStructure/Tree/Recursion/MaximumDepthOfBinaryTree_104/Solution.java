package DataStructure.Tree.Recursion.MaximumDepthOfBinaryTree_104;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    // 个人解法: DFS 回溯
    int max_depth = 0;
    int tmp_depth = 0;

    public int maxDepth(TreeNode root) {
        if(root == null){
            if(tmp_depth > max_depth){
                max_depth = tmp_depth;
            }
        }else{
            tmp_depth ++;
            maxDepth(root.left);
            maxDepth(root.right);
            tmp_depth --;
        }
        return max_depth;
    }

    // 官方题解 : DFS
    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_depth = maxDepth2(root.left);
        int right_depth = maxDepth2(root.right);
        int depth = Math.max(left_depth, right_depth) + 1;
        return depth;
    }
}
