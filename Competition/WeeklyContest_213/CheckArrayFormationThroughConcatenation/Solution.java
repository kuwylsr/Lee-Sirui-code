package WeeklyContest_213.CheckArrayFormationThroughConcatenation;

class Solution {

    // 他人解法: 
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int arr_len = arr.length;
        int[] ret = new int[arr.length];
        int index = 0;
        int i = 0;
        boolean flag = false;
        while(i < arr_len){ // 遍历 arr
            flag = false;
            for(int[] piece : pieces){ // 遍历 pieces
                if(piece[0] == arr[i]){ // 只要arr和某个piece的第一个字符匹配成功, 
                    flag = true;
                    for(int j = 0 ;j < piece.length;j++){ // 我们就将该piece全部写入ret数组
                        ret[index++] = piece[j];
                        i++;
                    }
                    break;
                }
            }
            if(flag == false){
                return false;
            }
        }
        for(int k = 0; k < arr_len ; k++){ // 将之前写好的ret数组 与 arr数组进行一一比较
            if(arr[k] != ret[k]){
                return false;
            }
        }
        return true;
    }
}