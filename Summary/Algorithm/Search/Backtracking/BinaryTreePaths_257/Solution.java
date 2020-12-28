package Algorithm.Search.Backtracking.BinaryTreePaths_257;

import java.util.ArrayList;
import java.util.List;

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

    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();
        backTrace(root,new ArrayList<Integer>());
        return res;
    }

    private void backTrace(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        if(node.left == null && node.right == null){
            res.add(convert(list));
            // 回溯
            list.remove(list.size()-1); //叶节点的左右节点(空)也都遍历完了,进行回溯,删除叶节点
            return;
        }
        backTrace(node.left,list);
        backTrace(node.right,list);
        //回溯
        list.remove(list.size()-1); //非叶节点的左右节点(空)也都遍历完了,进行回溯,删除非叶节点
    }

    private String convert(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() -1; i++){
            sb.append(list.get(i)).append("->");
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
        
    }

//-------------------------------------------------------------------
    // 使用String来存储当前路径 ,而而不是List<Integer>
    List<String> res2;

    public List<String> binaryTreePaths2(TreeNode root) {
        res = new ArrayList<String>();
        backTrace2(root,new String());
        return res;
    }

    private void backTrace2(TreeNode node, String tmpPath){
        if(node == null){
            return;
        }

        tmpPath += String.valueOf(node.val); 
        if(node.left == null && node.right == null){
            res.add(tmpPath);
            // 回溯
            // 不需要显示的回溯, 因为每次String做连接,都创建了一个新的对象.
            return;
        }
        tmpPath += "->";
        backTrace2(node.left,tmpPath);
        backTrace2(node.right,tmpPath);
        //回溯
        // 不需要显示的回溯, 因为每次String做连接,都创建了一个新的对象.
    }
}
