package DailyCoding.BinaryTreePostorderTraversal_145;

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

    // 左 右 根

    // 递归
    List<Integer> ans;

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

    // 迭代1 : 通过 插入null 的方式, 来判断每个根节点在之前时候访问过
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

    // 迭代2 : 可以通过给 TreaNode 在设置一个成员变量 isVisit 来标识它之前是否被访问过
}
