package WeeklyContest_221.DetermineIfStringHalvesAreAlike_5637;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int len = s.length();
        int mid = len/2 -1;
        
        char[] clist = s.toLowerCase().toCharArray();
        int num = 0;
        for(int i = 0 ; i < len ;i ++){
            if(set.contains(clist[i])){
                if(i <=mid){
                    num++;
                }else{
                    num--;
                }
            }
        }
        return num==0;
    }
}
