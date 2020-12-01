package DataStructure.Tree.Recursion.SymmetricTree_101;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    
    // 递归
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return match(root.left, root.right);
        }
    }

    public boolean match(TreeNode t1 , TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }else if (t1 == null && t2!=null){
            return false;
        }else if(t1 != null && t2 == null){
            return false;
        }else{
            if(t1.val != t2.val){
                return false;
            }else{
                return match(t1.left, t2.right) && match(t1.right, t2.left);
            }
            
        }
    }

    // 迭代: 
    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        TreeNode n1;
        TreeNode n2;
        // 每次弹出两个节点(两棵子树的根节点), 若两个节点值不相等, 则直接返回false
        // 压入时, 将两个子树的根节点的左右子树反向压入
        while(!queue.isEmpty()){ 
            n1 = queue.poll();
            n2 = queue.poll();

            if(n1 == null && n2 == null){
                continue;
            }

            if(n1 == null || n2 == null || n1.val != n2.val){
                return false;
            }

            queue.add(n1.left);
            queue.add(n2.right);

            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;

    }



    // 迭代: 层序遍历 这样写会超时, 可能是因为对最后一层的处理不当
    public boolean isSymmetric3(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> nums = new ArrayList<Integer>();
        int floor = 0;
        int count = 0; // 记录每一层空节点的个数(-1的个数)
        while(!queue.isEmpty()){
            if(queue.size() == (int)Math.pow(2, floor)){
                count = 0;
                for(int i = 0 ; i < Math.pow(2, floor) ; i++){
                    TreeNode n = queue.peek();
                    nums.add(n.val);
                    queue.poll();

                    if(n.val == -1){
                        count++;
                    }

                    n.left = n.left == null ? new TreeNode(-1) : n.left;
                    n.right = n.right == null ? new TreeNode(-1) : n.right;
                    queue.offer(n.left);
                    queue.offer(n.right);
                }
                if(IsPalindrome(nums) == false){
                    return false;
                }

                if(count == (int)Math.pow(2, floor)){
                    break;
                }
            }   
        }
        return true;
    }

    private boolean IsPalindrome(List<Integer> nums){
        int len = nums.size();
        if(len <= 1){
            return true;
        }else{
            for(int i = 0 ; i < Math.floor(len/2) ; i++){
                if(nums.get(i) != nums.get(len-1-i)){
                    return false;
                }
            }
            return true;
        }
    }
}
