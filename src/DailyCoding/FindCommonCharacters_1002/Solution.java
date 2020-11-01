package DailyCoding.FindCommonCharacters_1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    
    // 个人解法
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        String first = A[0];
        boolean flag;
        for(int i = 0 ; i < first.length(); i++) {
            flag = true;
            char c = first.charAt(i);
            for(int j = 1; j < A.length ; j++) {
                String s = A[j];
                int index = s.indexOf(c);
                if(index == -1){
                    flag = false;
                    break;
                }
                A[j] = s.substring(0, index) + s.substring(index + 1);
            }
            if(flag){
                result.add(c+"");
            }
        }
        return result;
    }

    // 参考题解:
    public List<String> commonChars2(String[] A) {
        int[] minchar = new int[26];
        Arrays.fill(minchar, Integer.MAX_VALUE); //初始化minchar数组
        for(String s : A) {
            int[] freq = new int[26];
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ++freq[c-'a'];
            }
            // 更新minchar
            for(int k = 0; k < 26 ; k++) {
                if(freq[k] < minchar[k]){
                    minchar[k] = freq[k];
                }
            }
        }
        // 输出结果
        List<String> ans = new ArrayList<String>();
        for(int i = 0 ; i < 26 ; i++){
            int count = minchar[i];
            for(int j = 0 ; j < count ; j++){
                ans.add(""+(char)('a'+i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        String[] A = {"cool","lock","cook"};
        List<String> ans = S.commonChars2(A);
        System.out.println(ans);
    }
}
