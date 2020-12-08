package JZOffer_38;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    
    // 个人解法 : 深搜回溯,变化子串
    Set<String> ans;
    private void trackback(String curStr, String s,int len){
        // 递归终止条件: 带搜索的字符串s只剩下1个字符 或者 没有字符时(可以去掉)
        if(len <= 0){
            ans.add(curStr);
            return;
        }else if(len == 1){
            curStr += s;
            ans.add(curStr);
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < len ; i++){
            
            char c = s.charAt(i);
            if(set.contains(c)){
                continue;
            }
            curStr += c;
            trackback(curStr,s.substring(0,i)+s.substring(i+1,len),len-1);
            // 回溯
            curStr = curStr.substring(0,curStr.length()-1);
        }
    }

    public String[] permutation(String s) {
        ans = new HashSet<String>();
        trackback("",s,s.length());
        return ans.toArray(new String[0]);
    }


    // 个人解法2 : 深搜回溯,利用visited数组记录
    boolean[] isVisited;
    private void trackback2(String curStr, char[] clist,boolean[] isVisited, int len){
        if(curStr.length() == len){ //递归终止条件
            ans.add(curStr);
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < len ; i++){
            if(!isVisited[i]){
                char c = clist[i];
                if(set.contains(c)){
                    isVisited[i] = true;
                    continue;
                }
                curStr += c;
                isVisited[i] = true;
                trackback2(curStr,clist,isVisited,len);
                // 回溯
                isVisited[i] = false;
                curStr = curStr.substring(0,curStr.length()-1);
            }
            
        }
    }

    public String[] permutation2(String s) {
        char[] clist = s.toCharArray();
        ans = new HashSet<String>();
        isVisited = new boolean[clist.length];
        Arrays.fill(isVisited,false);
        trackback2("",clist,isVisited,s.length());
        return ans.toArray(new String[ans.size()]);
    }

    // 参考题解:
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation3(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位 
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
