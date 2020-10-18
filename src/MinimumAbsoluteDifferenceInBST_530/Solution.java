package MinimumAbsoluteDifferenceInBST_530;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}

public class Solution {
    
    // 个人解法 :中序遍历二叉搜索树,按有序性求解
    int minValue = Integer.MAX_VALUE;
    int prevValue = Integer.MAX_VALUE;

    public void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        int val = Math.abs(root.val - prevValue);
        if(val < minValue){
            minValue = val;
        }
        prevValue = root.val;
        inorder(root.right);
    }

    public int getMinimumDifference(TreeNode root){
        inorder(root);
        
        return minValue;
    }

    public static void main(String[] args) {
        
    }
}
