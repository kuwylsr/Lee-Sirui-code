package Tree.Recursion.BalancedBinaryTree_110;

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

    // 个人解法 : 利用全局变量flag 来判断是否出现不平衡
    boolean flag = true;
    private int recursionCalHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_depth = recursionCalHeight(root.left);
        int right_depth = recursionCalHeight(root.right);
        if(Math.abs(left_depth-right_depth) > 1){
            flag = false;
        }
        return Math.max(left_depth, right_depth)+1;
    }

    public boolean isBalanced(TreeNode root) {
        recursionCalHeight(root);
        return flag;
    }

    // 官方题解: 利用返回值为 -1 代表出现了不平衡, 可以提前终止
    private int recursionCalHeight2(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_depth = recursionCalHeight2(root.left);
        int right_depth = recursionCalHeight2(root.right);
        if(Math.abs(left_depth-right_depth) > 1 || left_depth == -1 || right_depth == -1){
            return -1;
        }
        return Math.max(left_depth, right_depth)+1;
    }

    public boolean isBalanced2(TreeNode root) {
        int ans = recursionCalHeight2(root);
        return ans != -1;
    }

    /**
     * 按层序编号建立树
     * @param vals
     * @return
     */
    public TreeNode createTree(int[] vals){
        int len = vals.length;
        TreeNode[] list = new TreeNode[len];
        for(int i = 0; i < len; i++){
            if(vals[i] != -1){
                list[i] = new TreeNode(vals[i]);
            }else{
                list[i] = null;
            }
        }

        for(int i = 0; 2*i+2 < len ; i++){
            list[i].left = list[i*2+1];
            list[i].right = list[i*2+2];
        }
        return list[0];
    }

    public void printOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        printOrder(root.left);
        printOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] val = {3,9,20, -1, -1, 15, 7 };
        TreeNode root = solution.createTree(val);
        // solution.printOrder(root);
        int ans = solution.recursionCalHeight(root);
        System.out.println(ans);
    }

}
