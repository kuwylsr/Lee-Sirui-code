package DailyCoding.BackspaceStringCompare_844;

public class Solution {

    // 个人解法: 双指针 (倒向遍历)
    public boolean backspaceCompare(String S, String T) {
        int lenS = S.length();
        int lenT = T.length();
        int ps = lenS - 1; //初始化指向S末尾字符的指针
        int pt = lenT - 1; //初始化指向T末尾字符的指针
        int remove_num_s = 0; //记录当前S可以跳过的字符数量
        int remove_num_t = 0; //记录当前T可以跳过的字符数量
        char s;
        char t;
        while(ps>=0 || pt >=0){
            s = ps >= 0 ? S.charAt(ps) : ' ';
            t= pt >= 0 ? T.charAt(pt) : ' ';
            if(s != '#' && t != '#'){
                if(remove_num_s == 0 && remove_num_t == 0){
                    if(s != t){
                        return false;
                    }else{
                        ps--;
                        pt--;
                    }
                }else if(remove_num_s == 0 && remove_num_t != 0){
                    remove_num_t--;
                    pt--;
                }else if(remove_num_s != 0 && remove_num_t == 0){
                    remove_num_s--;
                    ps--;
                }else{
                    remove_num_t--;
                    pt--;
                    remove_num_s--;
                    ps--;
                }   
            }else{
                if(s == '#'){
                    remove_num_s++;
                    ps--;
                }
                if(t == '#'){
                    remove_num_t++;
                    pt--;
                }
            }
        }
        if(ps <0 && pt <0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "y#fo##f";
        String T = "y#fx#o##f";
        boolean ans = solution.backspaceCompare(S, T);
        System.out.println(ans);
    }
}
