package JZOffer_26;

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
    public boolean isSubStructure(TreeNode A , TreeNode B){
        if(B == null || A == null){ //子结构中, 不与空子树匹配
            return false;
        }
        return isMatch(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
        
    }

    private boolean isMatch(TreeNode A , TreeNode B){
        if(A != null && B == null){ //两个树进行匹配, A可以与为空的B进行匹配.
            return true;
        }else if(A == null && B == null){
            return true;
        }else if(A == null && B != null){
            return false;
        }

        if(A.val != B.val){
            return false;
        }else{
            return isMatch(A.left,B.left) && isMatch(A.right,B.right);
        }
    }
}
