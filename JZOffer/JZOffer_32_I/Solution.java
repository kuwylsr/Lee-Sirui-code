package JZOffer_32_I;

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

    // BFS
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            res.add(t.val);
            
            if(t.left != null){
                queue.offer(t.left);
            }
            if(t.right != null){
                queue.offer(t.right);
            }
        }
        int[] arrayRes = new int[res.size()];
        for(int i = 0 ; i < res.size() ;i++){
            arrayRes[i] = res.get(i);
        }
        return arrayRes;
    }
}
