package Algorithm.Search.Backtracking.LetterCombinationsOfAPhoneNumber_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();

        if(digits.length() == 0){
            return res;
        }
        
        Map<Character,String> map = new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        char[] charDigits = digits.toCharArray();
        backTrace(charDigits, 0, map, new String());
        return res;
    }

    /**
     * 
     * @param charDigits 输入的数字字符数组
     * @param index 当前要遍历的数字的下标
     * @param map 数字到其表征字符的字典
     * @param tmpResult 记录当前结果的字符串
     */
    private void backTrace(char[] charDigits,int index, Map<Character,String> map, String tmpResult){
        
        if(tmpResult.length() == charDigits.length){
            res.add(tmpResult);
            return;
        }
        
        char[] clist = map.get(charDigits[index]).toCharArray();
        for(char c : clist){
            tmpResult = tmpResult + String.valueOf(c);
            backTrace(charDigits, index+1, map, tmpResult);
            // 回溯
            tmpResult = tmpResult.substring(0,tmpResult.length()-1);
        }
    }
}
