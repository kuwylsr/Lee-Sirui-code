package DataStructure.Tree.Recursion.PathSumII_113;

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

    // 个人解法
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> cur_path = new ArrayList<Integer>();
    // 深搜 + 递归
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        sum -= root.val;
        cur_path.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == 0){
                result.add(new ArrayList<Integer>(cur_path)); //注意此处要进行浅拷贝
            }
        }

        pathSum(root.left, sum);
        pathSum(root.right, sum);
        cur_path.remove(cur_path.size()-1); //当搜索完左右子树, 回退该结点
        return result;
    }

    // 改变返回值, 看是否节省时间
    private void dfs(TreeNode root, int sum){
        if(root == null){
            return ;
        }

        sum -= root.val;
        cur_path.add(root.val);
        if(root.left != null && root.right != null){
            if(sum == 0){
                result.add(new ArrayList<Integer>(cur_path));
            }
        }

        // 深搜
        dfs(root.left,sum);
        dfs(root.right,sum);
        // 左右子树都遍历完之后
        cur_path.remove(cur_path.size() - 1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        dfs(root,sum);
        return result;
    }
}
