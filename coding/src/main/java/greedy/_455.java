package greedy;

import java.util.Arrays;

public class _455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0,count=0;
        while(i<g.length&&j<s.length){
            while(j<s.length){
                if(g[i]<=s[j++]){
                    count++;
                    break;
                }
            }
            i++;
        }
        return count;
    }
}
