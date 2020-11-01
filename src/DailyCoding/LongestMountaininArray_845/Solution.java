package DailyCoding.LongestMountaininArray_845;

public class Solution {
    // 个人解法: 双指针,找山脚
    public int longestMountain(int[] A){
        if(A.length < 3){
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        int temp_len = 0;
        int max_len = 0;
        boolean flag = false; // 山脚指针没有初始化
        while(p2 < A.length - 1){
            if(!flag){ // 初始化山脚指针,找到第一个要上升的点
                while(p1 < A.length -1){
                    if(A[p1+1] <= A[p1]){
                        p1++;
                    }else{
                        break;
                    }
                }
                flag = true;
                p2 = p1 + 1;
                continue;
            }

            if(A[p2] < A[p2-1] && A[p2] <= A[p2+1]){ // 找到第二个山脚
                temp_len = p2 - p1 + 1;
                if(temp_len > max_len){
                    max_len = temp_len;
                }
                temp_len = 0;
                p1 = p2;
            }

            if(A[p2] == A[p2 + 1]){ //重新初始化山脚
                p1 = p2;
                flag = false;
                continue;
            }
            
            p2++;
        }
        if((p2 == A.length - 1) && (A[p2]<A[p2-1])){ //判断最后一个点是否为山脚的情况
            temp_len = p2 - p1 + 1;
            if(temp_len > max_len){
                max_len = temp_len;
            }
        }
        return max_len;
    }
}
