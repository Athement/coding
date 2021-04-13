package slidewindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int pre = need.getOrDefault(c, 0);
            need.put(c, pre + 1);
        }
        Map<Character, Integer> needCp = new HashMap<>();
        needCp.putAll(need);
        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (needCp.containsKey(c)) {
                int cur = needCp.get(c)-1;
                if (cur< 0) {
                    char c1=s2.charAt(left++);
                    while (c1!= c) {
                        needCp.put(c1,needCp.get(c1)+1);
                        c1=s2.charAt(left++);
                    }
                    cur=0;
                }else if (cur == 0) {
                    if (right - left == s1.length()) {
                        return true;
                    }
                }
                needCp.put(c,cur);
            } else {
                left = right;
                needCp=new HashMap<>();
                needCp.putAll(need);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _567 test = new _567();
        System.out.println(test.checkInclusion("hello",
                "ooolleoooleh"));
    }
}
