package BinaryTreePreorderTraversal_144;

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

public class Solution {

    //----------------------前序遍历-----------------------------
    // 递归
    List<Integer> ans;

    public void preorder(TreeNode root){
        if(root == null){
            return ;
        }
        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<Integer>();
        preorder(root);
        return ans;
    }

    // 迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node == null){
                continue;
            }else{
                stack.add(node.right);
                stack.add(node.left);
                ans.add(node.val);
            }
        }
        return ans;
    }

    // 迭代2 : 先序遍历 也可以统一为 添加null 的方式,但是没必要

    //------------------------中序遍历-----------------------
    // 左 根 右

    // 递归
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


    //------------------------后序遍历-----------------------
    // 左 右 根

    // 递归
    public void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root){
        ans = new ArrayList<Integer>();
        postorder(root);
        return ans;
    }

    // 迭代
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return ans;
        }
        stack.add(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(node != null){
                // 对于后序来说,此时不弹出也可以,因为弹出之后也要再将根压进去..
                stack.pop(); // 弹出当前根节点

                stack.add(node); // 压根节点
                stack.add(null); // 压根节点之后,在压入一个null

                if(node.right != null){ //压入右节点
                    stack.add(node.right);
                }

                if(node.left != null){ //压入左节点
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
