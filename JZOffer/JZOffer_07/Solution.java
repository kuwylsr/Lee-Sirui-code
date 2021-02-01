package JZOffer_07;

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

    // 方法一: 
    int prerootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0){
            return null;
        }
        TreeNode root = recursion(0,len-1,preorder,inorder);
        return root;
    }

    private TreeNode recursion(int left, int right, int[] preorder, int[] inorder){
        if(left > right){
            return null;
        }
        int rootIndex = -1;
        TreeNode root = new TreeNode(preorder[prerootIndex]);

        for(int i = left ;i <= right ; i++){
            if(inorder[i] == preorder[prerootIndex]){
                rootIndex = i;
                prerootIndex++;
                break;
            }
        }

        root.left = recursion(left,rootIndex-1,preorder,inorder);
        root.right = recursion(rootIndex+1,right,preorder,inorder);
        return root;
    }

    // 方法二 : 利用hashmap进行优化, 空间换时间

}
