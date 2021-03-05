package DataStructure.Tree.Recursion.BinaryTreeRightSideView_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    // 解法一 : 层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            res.add(queue.peek().val); //每一层只要第一个节点的值
            int tmpSize = queue.size();
            while(tmpSize > 0){ //清空当前层, 加入下一层
                TreeNode tmpNode = queue.poll();
                if(tmpNode.right != null){
                    queue.offer(tmpNode.right);
                }
                if(tmpNode.left != null){
                    queue.offer(tmpNode.left);
                }
                tmpSize --;
            }
        }

        return res;
    }

    // 解法二 : 递归, 深度优先搜索(根 右 左)
    List<Integer> res;
    public List<Integer> rightSideView2(TreeNode root) {
        res = new ArrayList<Integer>();
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int deepth){
        if(root == null){
            return ;
        }
        if(deepth == res.size()){ //每个深度只要第一个节点值
            res.add(root.val);
            
        }
        deepth++;
        dfs(root.right, deepth);
        dfs(root.left,deepth);
    }
}
