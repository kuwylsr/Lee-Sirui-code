package DataStructure.Tree.Recursion.SubtreeOfAnotherTree_572;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val , TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }

        boolean a = matchSubTree(s,t);
        boolean b = isSubtree(s.left,t);
        boolean c = isSubtree(s.right,t);
        return a||b||c;
    }

    private boolean matchSubTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }else if (s == null && t!=null){
            return false;
        }else if(s != null && t == null){
            return false;
        }else{
            if(s.val != t.val){
                return false;
            }else{
                return matchSubTree(s.left,t.left) &&
                matchSubTree(s.right,t.right);
            }
            
        }
    }
}
