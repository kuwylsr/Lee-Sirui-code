package DataStructure.Tree.Recursion.InvertBinaryTree_226;

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

    // 个人解法: 深度优先搜索 (先序)
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 也可以后序遍历
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        invertTree2(root.left);
        invertTree2(root.right);
        
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        return root;
    }
}
