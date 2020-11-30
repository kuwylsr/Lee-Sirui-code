package DataStructure.Tree.Recursion.PathSumIII_437;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    // 个人解法: 遍历每个结点作为开始结点, 依次深搜
    int path_sum;
    List<TreeNode> node_list;

    public int pathSum(TreeNode root, int sum) {
        path_sum = 0;
        node_list = new ArrayList<TreeNode>();
        dfs(root);
        for (TreeNode t : node_list) {
            solveDfs(t, sum);
        }
        return path_sum;
    }

    // 前序遍历深搜, 将所有结点放入一个ArrayList中
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        node_list.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    private void solveDfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            path_sum++;
        }
        solveDfs(root.left, sum);
        solveDfs(root.right, sum);
    }

    // 参考题解: 双递归
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        countPath(root, sum); // 计算以root为起点的路径
        pathSum2(root.left, sum); //递归遍历左子树
        pathSum2(root.right, sum); //递归遍历右子树
        return path_sum;
    }

    /**
     * 计算以当前root为起点的路径是否存在权值和为sum的路径
     * @param root
     * @param sum
     */
    private void countPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            path_sum++;
        }
        countPath(root.left, sum);
        countPath(root.right, sum);
    }

    // 参考题解 : 利用前缀和求解
    // 时间复杂度 : O(N)
    // 空间复杂度 : O(N)
    int res;

    private void recursionPathSum(TreeNode root, Map<Integer, Integer> map, int target, int CurSum) {
        if (root == null) {
            return ;
        }

        CurSum += root.val; //更新前缀和

        // 核心:
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += map.getOrDefault(CurSum - target, 0); //取出前缀和为 CurSum - target 的结点的个数(找不到则为0), 加到结果集

        map.put(CurSum, map.getOrDefault(CurSum, 0) + 1); // 更新map

        //深搜
        recursionPathSum(root.left, map,target, CurSum); 
        recursionPathSum(root.right, map,target, CurSum);

        //回溯, 当遍历完左右子树之后, 需要将此根节点的前缀和去掉(因为只有它的子树结点能使用它的前缀和)
        map.put(CurSum,map.getOrDefault(CurSum,0)-1);
    }

    public int pathSum3(TreeNode root, int sum) {
        res = 0;
        // 定义一个 HashMap, key为前缀和, value为前缀和为key的结点个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1); // 前缀和为0的一条路径(即从当前根节点开始的一条路径)

        recursionPathSum(root, map, sum, 0);
        return res;
    }
}
