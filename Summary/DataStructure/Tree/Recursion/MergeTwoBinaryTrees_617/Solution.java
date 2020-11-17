package DataStructure.Tree.Recursion.MergeTwoBinaryTrees_617;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){ //如果t1为空, 则直接返回t2子树
            return t2;
        }else if(t2 == null){ //如果t2为空, 则直接返回t1子树
            return t1;
        }else { // 都不为空,树结点值相加
            t1.val = t1.val + t2.val;
        }
        
        // 深搜
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
