package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class _76 {
    public String minWindow(String s, String t) {
        //保存条件
        Map<Character, Integer> need = new HashMap<>();
        //保存条件总数
        int count = t.length();
        for (char c : t.toCharArray()) {
            int pre = need.getOrDefault(c, 0);
            need.put(c, pre + 1);
        }
        //定义左右边界
        int left = 0, right = 0;
        int rl = 0, rr = Integer.MAX_VALUE;
        char c = ' ';
        while (right < s.length()) {
            c = s.charAt(right++);
            if(t.indexOf(c)==-1){
                continue;
            }
            need.put(c, need.get(c) - 1);
            if (need.get(c) >= 0) {
                count--;
            }

            while (count == 0) {
                if (right - left < rr - rl) {
                    rl = left;
                    rr = right;
                }
                c = s.charAt(left++);
                if(t.indexOf(c)==-1){
                    continue;
                }
                need.put(c, need.get(c) + 1);
                if (need.get(c) > 0) {
                    count++;
                }
            }

        }
        if(rr-rl==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(rl,rr);
    }

    public static void main(String[] args) {
        _76 test=new _76();
        System.out.println(test.minWindow("a","aa"));
    }
}
