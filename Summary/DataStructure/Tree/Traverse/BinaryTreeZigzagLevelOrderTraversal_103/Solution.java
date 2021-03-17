package DataStructure.Tree.Traverse.BinaryTreeZigzagLevelOrderTraversal_103;

import java.util.ArrayList;
import java.util.Deque;
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

    // 方法一 : 个人方法
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }
        deque.offerFirst(root);
        int flag = 0;
        while(!deque.isEmpty()){
            List<Integer> tmpRes = new ArrayList<Integer>();
            int size = deque.size();
            for(int i = 0 ; i < size ; i++){
                if(flag%2 == 0){ // 从队列头出, 从队列尾进, 先左子树后右子树
                    TreeNode node = deque.pollFirst();
                    tmpRes.add(node.val);
                    if(node.left != null){
                        deque.offerLast(node.left);
                    }
                    if(node.right != null){
                        deque.offerLast(node.right);
                    }
                }else{ // 从队列尾出, 从队列头进, 先右子树后左子树
                    TreeNode node = deque.pollLast();
                    tmpRes.add(node.val);
                    if(node.right != null){
                        deque.offerFirst(node.right);
                    }
                    if(node.left != null){
                        deque.offerFirst(node.left);
                    }
                }
            }
            flag ++;
            res.add(tmpRes);
        }
        return res;
    }

    // 方法二 : 
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        int flag = 0;
        while(!queue.isEmpty()){
            LinkedList<Integer> dequeRes = new LinkedList<Integer>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                if(flag%2 == 0){
                    dequeRes.offerFirst(node.val);
                }else{
                    dequeRes.offerLast(node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            flag ++;
            res.add(dequeRes);
        }
        return res;
    }
}
