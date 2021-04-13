package graph.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _765 {
    int[] parent;
    int[] size;
    public int minSwapsCouples(int[] row) {
        parent=new int[row.length];
        size=new int[row.length];
        Arrays.fill(size,1);
        for(int i=0;i<row.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<row.length;i+=2){
            union(i,i+1);
        }
        for(int i=0;i<row.length;i+=2){
            if(find(row[i])!=find(row[i+1])){
                union(row[i],row[i+1]);
            }
        }
        int res=0;
        for(int s:size){
            if(s>0){
                res+=s/2-1;
            }
        }
        return res;
    }

    public int find(int i){
        int tmp=i;
        while(i!=parent[i]){
            i=parent[i];
        }
        parent[i]=i;
        return i;
    }

    public int size(int i){
        return size[parent[i]];
    }

    public void union(int i,int j){
        int pi=find(i);
        int pj=find(j);
        if(pi>pj) {
            parent[pi] = pj;
            size[pj]+=size[pi];
            size[pi]=0;
        }else{
            parent[pj]=pi;
            size[pi]+=size[pj];
            size[pj]=0;
        }
    }

    public static void main(String[] args) {
        _765 test=new _765();
        System.out.println(test.minSwapsCouples(new int[]{0,3,1,4,2,5}));
    }
}
