package JZOffer_05;

import java.util.ArrayList;

public class Solution {

    // 个人解法:
    public String replaceSpace1(String s) {
        ArrayList<Integer> indexList = new ArrayList<Integer>(); // 记录 空格 出现的位置
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                indexList.add(i);
            }
        }
        int bios = 0;
        for(int index : indexList){ // 对空格的位置进行替换
            index += bios;
            s = s.substring(0,index) + "%20" + s.substring(index+1); //substring() 方法效率较低,每次执行都要 new String()
            bios += 2;
        }
        return s;
    }

    // 官方题解:
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public String replaceSpace2(String s){
        int len = s.length();
        char[] ans_c = new char[len * 3]; // 结果集合的 char数组
        int index = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == ' '){
                ans_c[index++] = '%'; //下标更新并赋值
                ans_c[index++] = '2';
                ans_c[index++] = '0';
            }else{
                ans_c[index++] = c;
            }
        }
        String ans = new String(ans_c,0,index); //将char[] 转化为String
        return ans;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        String s = "We are happy!";
        String ans = S.replaceSpace2(s);
        System.out.println(ans);
    }
}
