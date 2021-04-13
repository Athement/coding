package graph.dfs;

import java.util.*;

public class _753 {
    Set<Integer> seen = new HashSet<Integer>();
    StringBuffer ans = new StringBuffer();
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        this.k=k;
        highest=(int)Math.pow(10,n-1);
        int node=0;
        dfs(0);
        for(int i=1;i<n;i++){
            ans.append(0);
        }
        return ans.toString();
    }

    private void dfs(int node) {
        for(int i=0;i<k;i++){
            int newNode=node*10+i;
            if(!seen.contains(newNode)){
                seen.add(newNode);
                dfs(newNode);
                ans.append(i);
            }
        }
    }

}
