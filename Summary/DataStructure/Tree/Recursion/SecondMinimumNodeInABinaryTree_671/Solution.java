package DataStructure.Tree.Recursion.SecondMinimumNodeInABinaryTree_671;


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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }else if(root.left == null && root.right == null){
            return -1;
        }

        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
        
        if(l == -1 && r == -1){ //说明不存在第二小的值
            return -1;
        }else{
            int tmp = Math.min(l,r);
            if(tmp == -1){
                return Math.max(l,r);
            }else{
                return Math.min(l,r);
            }
        }
    }
}
