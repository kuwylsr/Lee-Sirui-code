package Algorithm.Search.Backtracking;

import java.util.List;

public class Solution {
    
    List<String> res;

    private void backTrace(String s, int index, List<Integer> dotList){
        int len = s.length();

        if(dotList.size() == 3){
            int flag = 0;
            int pre = 0;
            for(int i : dotList){
                if(!isillegal(s.substring(pre,i+1))){
                    flag = 1;
                    break;
                }
                pre = i+1;
            }
            if(flag == 0 && isillegal(s.substring(pre))){
                
            }
        }

        
        for(int i = index ; i < len-1 ; i++){
            dotList.add(i);
            backTrace(s,index+1,dotList);
            dotList.remove(dotList.size()-1);
        }

    }

    private boolean isillegal(String subs){
        char[] clist= subs.toCharArray();
        int len = clist.length;
        if(c[0] == '0' && len == 1){
            return false;
        }
    }

    public List<String> restoreIpAddresses(String s) {

    }
}
