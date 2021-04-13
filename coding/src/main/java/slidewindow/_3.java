package slidewindow;

import java.util.HashSet;
import java.util.Set;

public class _3 {
    public int lengthOfLongestSubstring(String s) {
        int[] need =new int[128];
        int left=0,right=0;
        int max=0;
        while(right<s.length()){
            int idxR=s.charAt(right++)-'\000';
            need[idxR]++;
            while(need[idxR]>1){
                int idxL=s.charAt(left++)-'\000';
                need[idxL]--;
            }
            max=Math.max(max,right-left);
        }
        return max;
    }

    public static void main(String[] args) {
        _3 test=new _3();
        System.out.println(test.lengthOfLongestSubstring("abcacbced"));
    }
}
