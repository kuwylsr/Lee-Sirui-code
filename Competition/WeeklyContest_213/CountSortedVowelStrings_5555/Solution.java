package WeeklyContest_213.CountSortedVowelStrings_5555;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int sum;
    public void backtrace(char[] list, List<Character> tempstr, int n) {
        if (tempstr.size() == n) { // 递归搜索终止条件
            sum++;
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (tempstr.isEmpty()) {
                tempstr.add(list[i]);
            } else {
                if (list[i] >= tempstr.get(tempstr.size() - 1)) { //如果第二个字符的字典序大于第一个字符,则加入
                    tempstr.add(list[i]);
                } else { // 否则直接剪枝,不能继续深搜
                    continue;
                }
            }

            backtrace(list, tempstr, n); // 按深搜索
            tempstr.remove(tempstr.size() - 1); //搜到底了, 回溯
        }
    }

    public int countVowelStrings(int n) {
        sum = 0;
        List<Character> tempstr = new ArrayList<>();
        char[] list = { 'a', 'e', 'i', 'o', 'u' };
        backtrace(list, tempstr, n);
        return sum;
    }
}
