package Tree.Recursion.BalancedBinaryTree_110;

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

    // 个人解法 : 
    boolean flag = true;
    private int recursionCalHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_depth = recursionCalHeight(root.left);
        int right_depth = recursionCalHeight(root.right);
        if(Math.abs(left_depth-right_depth) > 1){
            flag = false;
        }
        return Math.max(left_depth, right_depth)+1;
    }

    public boolean isBalanced(TreeNode root) {
        recursionCalHeight(root);
        return flag;
    }

    // 官方题解:
    private int recursionCalHeight2(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_depth = recursionCalHeight2(root.left);
        int right_depth = recursionCalHeight2(root.right);
        if(Math.abs(left_depth-right_depth) > 1 || left_depth == -1 || right_depth == -1){
            return -1;
        }
        return Math.max(left_depth, right_depth)+1;
    }

    public boolean isBalanced2(TreeNode root) {
        int ans = recursionCalHeight2(root);
        return ans != -1;
    }

}
