package JZOffer_32_II;

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

    // 方法一: 用额外的一个队列存储节点所在的层数(麻烦)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int deep = 0;
        Queue<Integer> queueDeepth = new LinkedList<Integer>();
        queueDeepth.offer(deep);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int tmpDeepth = queueDeepth.poll();
            if(tmpDeepth > res.size() - 1){
                List<Integer> tmpdeepthRes = new ArrayList<Integer>();
                tmpdeepthRes.add(node.val);
                res.add(tmpdeepthRes);
            }else{
                res.get(tmpDeepth).add(node.val);
            }

            if(node.left != null){
                queue.offer(node.left);
                queueDeepth.offer(tmpDeepth + 1);
            }

            if(node.right != null){
                queue.offer(node.right);
                queueDeepth.offer(tmpDeepth + 1);
            }
        }
        return res;
    }

    // 方法二 : 通过当前队列的长度直接按层输出(巧妙)
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> tmpRes = new ArrayList<Integer>();
            int tmpSize = queue.size(); //获取当前队列中的元素个数(都在一层)
            for(int i = 0 ; i < tmpSize ; i++){
                TreeNode node = queue.poll();
                tmpRes.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(tmpRes);
        }
        return res;   
    }
}
