package DataStructure.String.ValidAnagram_242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 利用类似计数排序的思想
    public boolean isAnagram(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        if(len_s != len_t){
            return false;
        }

        int[] count = new int[26]; //字符的int型作为下标,字符出现的次数作为值
        Arrays.fill(count,0);

        for(int i = 0; i < len_s ;i++){
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for(int num : count){
            if(num != 0){
                return false;
            }
        }
        return true;
    }   

    // 哈希表解法
    public boolean isAnagram2(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        if(len_s != len_t){
            return false;
        }

        Map<Character,Integer> map_s = new HashMap<>();
        Map<Character,Integer> map_t = new HashMap<>();
        
        // 统计字符串s中每个字符的出现次数
        for(int i = 0 ; i< len_s ;i ++){
            char c = s.charAt(i);
            if(map_s.containsKey(c)){
                map_s.put(c, map_s.get(c) + 1);
            }else{
                map_s.put(c,0);
            }
        }

        // 统计字符串t中每个字符的出现次数
        for(int i = 0 ; i< len_t ;i ++){
            char c = t.charAt(i);
            if(map_t.containsKey(c)){
                map_t.put(c, map_t.get(c) + 1);
            }else{
                map_t.put(c,0);
            }
        }

        // 比较两个map集合是否相同(里面的key,value都相同)
        if(map_s.equals(map_t)){
            return true;
        }else{
            return false;
        }
    }
}
