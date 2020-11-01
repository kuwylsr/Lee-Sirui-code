package BinaryTreeInorderTraversal_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class Solution {

    // 左 根 右

    // 递归
    List<Integer> ans;
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root){
        ans = new ArrayList<Integer>();
        inorder(root);
        return ans;
    }
    
    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) {
            return ans;
        }
        stack.add(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop(); //弹出当前根节点

                if(node.right != null){ // 压右节点
                    stack.add(node.right);
                }

                stack.add(node); // 压根节点
                stack.add(null); // 压根节点之后,在压入一个null

                if(node.left != null){ // 压左节点
                    stack.add(node.left);
                }
            }else{
                stack.pop();
                node = stack.peek();
                ans.add(node.val);
                stack.pop();
            }
        }
        return ans;
    }
    
}
