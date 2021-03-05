package DataStructure.Tree.Recursion.BinaryTreeMaximumPathSum_124;

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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMain(root);
        return max;
    }

    public int getMain(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(getMain(root.left),0); // 左节点的最大贡献值(若最大贡献值小于0,则取0)
        int right = Math.max(getMain(root.right),0); // 右节点的最大贡献值(若最大贡献值小于0,则取0)

        int tmpPathMax = root.val + left + right; // 包含当前root节点(以root为根)的最大路径和
        if(tmpPathMax > max){
            max = tmpPathMax;
        }

        // 返回当期root节点的最大贡献值
        return root.val + Math.max(left,right);
    }
}
