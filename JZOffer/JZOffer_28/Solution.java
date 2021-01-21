package JZOffer_28;

class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMatch(root.left, root.right);
    }

    private boolean isMatch(TreeNode A, TreeNode B){
        if(A == null && B == null){
            return true;
        }else if(A == null || B == null){
            return false;
        }

        if(A.val != B.val){
            return false;
        }else{
            return isMatch(A.left,B.right) && isMatch(A.right, B.left);
        }
    }
}
