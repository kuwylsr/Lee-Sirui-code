package WeeklyContest_220.ReformatPhoneNumber_5629;

public class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        char[] nums = number.toCharArray();
        
        for(char c : nums){
            if(c == ' ' || c == '-'){
                continue;
            }
            sb.append(c);
        }
        String number_delete = sb.toString();
        
        StringBuilder res = new StringBuilder();
        int len = number_delete.length();
        int z = len / 3;
        int m = len % 3;
        if(m == 0){
            for(int i = 0 ; i < len ; i++){
                res.append(number_delete.charAt(i));
                if((i+1)%3 == 0 && i != len-1){
                    res.append("-");
                }
            }
        }else if(m == 1){
            int z_tmp = z - 1;
            for(int i = 0 ; i < z_tmp*3 ; i++){
                res.append(number_delete.charAt(i));
                if((i+1)%3 == 0){
                    res.append("-");
                }
            }
            res.append(number_delete.charAt(len-4)).append(number_delete.charAt(len-3)).append("-").append(number_delete.charAt(len-2)).append(number_delete.charAt(len-1));

        }else if(m == 2){
            for(int i = 0 ; i < z*3 ; i++){
                res.append(number_delete.charAt(i));
                if((i+1)%3 == 0){
                    res.append("-");
                }
            }
            res.append(number_delete.charAt(len-2)).append(number_delete.charAt(len-1));
        }
        return res.toString();
        
    }
}
