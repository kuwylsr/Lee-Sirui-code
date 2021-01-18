package DataStructure.Tree.Recursion.SumOfLeftLeaves_404;


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

    // 个人写法:
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return sum;
        }
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }else{
                sumOfLeftLeaves(root.left);
            }
        }
        sumOfLeftLeaves(root.right);
        return sum;
    }

    // 简洁写法:
    public int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        if(root == null){
            return 0;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;            
        }
        
        return sum + sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
    }
}
