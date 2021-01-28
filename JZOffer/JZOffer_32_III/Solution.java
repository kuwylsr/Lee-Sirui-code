package JZOffer_32_III;

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
        this.left =null;
        this.right = null;
    }
}

public class Solution {

    // 层序遍历 + 双端队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //单端队列
        queue.add(root);
        
        int level = 0; //定义层数(第0层开始)
        while(!queue.isEmpty()){
            LinkedList<Integer> deque = new LinkedList<Integer>(); //定义一个双端队列
            int tmpSize = queue.size();
            for(int i = 0 ; i < tmpSize ; i++){
                TreeNode node = queue.poll();
                if(level % 2 == 0){ //偶数层, 从左向右
                    deque.offerLast(node.val);
                }else{ //奇数层, 从右向左
                    deque.offerFirst(node.val);
                }

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(deque);
        }
        return res;
    }
}
