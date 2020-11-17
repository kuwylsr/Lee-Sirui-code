package DataStructure.Tree.Recursion.DiameterOfBinaryTree_543;

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

    //个人解法: 
    int max_diameter;

    public int calDeep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_d = calDeep(root.left);
        int right_d = calDeep(root.right);

        // 更新经过当前子树根root的最长路径
        max_diameter = Math.max(left_d + right_d, max_diameter);

        // 计算当前根结点深度
        int root_d = Math.max(left_d, right_d) + 1; //左右子树深度的最大值 + 1
        return root_d;
    }

    // 每颗子树的直径长度为,该子树根节点左右子树的深度之和
    public int diameterOfBinaryTree(TreeNode root) {
        max_diameter = 0;
        calDeep(root);
        return max_diameter;
    }

    public static void main(String[] args){

    }
}