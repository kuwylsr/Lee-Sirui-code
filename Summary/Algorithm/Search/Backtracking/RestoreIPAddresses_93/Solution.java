package Algorithm.Search.Backtracking.RestoreIPAddresses_93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<String>();
        backTrace(s, 0, new String[4], 0);
        return res;
    }

    /**
     * 
     * @param s 数字字符串
     * @param index 当前开始形成某个segment的其实下标
     * @param tmpResult 存储当前结果的数组(长度为4)
     * @param segmentNum 当前要形成的segment的序号(第几个segment)
     */
    private void backTrace(String s, int index, String[] tmpResult, int segmentNum){
        
        // 递归终止条件 : 已经形成了四段符合要求的串
        if(segmentNum == 4){
            if(index == s.length()){ //刚好用完了字符串的所有字符
                //复原ip,并添加到结果集合
                restore(tmpResult);
            }
            return;
        }

        if(index == s.length()){ // 如果没形成四段, 就用完了字符串的所有字符, 则终止.
            return;
        }

        // 首先看一下第一个字符是否为0, 避免前导0的出现
        if(s.charAt(index) == '0'){
            tmpResult[segmentNum] = "0";
            backTrace(s,index+1,tmpResult,segmentNum+1);
            return; //如果第一个字符是0, 则只有这一种情况,遍历完成后直接return
            // 不需要回溯
        }  

        StringBuilder tmp = new StringBuilder();
        for(int i = index ; i < s.length() ; i++){
            tmp.append(s.charAt(i));;
            if(Integer.parseInt(tmp.toString()) <= 255){ //因为前导0已经被去掉
                tmpResult[segmentNum] = tmp.toString();
                backTrace(s,i+1,tmpResult,segmentNum+1);
                // 回溯
                // 这里的回溯就是将当前segment继续扩展, 然后填入到tmpResult进行覆盖.
            }else{
                break; //提前终止
            }
        }
    }

    private void restore(String[] tmpResult){
        String ans = "";
        for(String s : tmpResult){
            ans = ans + s + '.';
        }
        res.add(ans.substring(0,ans.length()-1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "010010";
        List<String> ans = solution.restoreIpAddresses(s);
        for(String ss : ans){
            System.out.println(ss);
        }
    }


}
