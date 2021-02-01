package JZOffer_33;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        return recursion(0,len-1,postorder);
    }

    private boolean recursion(int left, int right, int[] postorder){
        if(left >= right){
            return true;
        }
        int index = left;
        while(postorder[index] < postorder[right]){
            index++;
        }
        int partition = index-1;
        while(postorder[index] > postorder[right]){
            index++;
        }

        return (index == right) && recursion(left,partition,postorder) && recursion(partition+1,right-1,postorder);
    }
}
