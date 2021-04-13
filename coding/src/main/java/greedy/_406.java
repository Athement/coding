package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class _406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res=new int[people.length][];
        Arrays.sort(people,(int[] a,int[] b)->{
            if(a[0]==b[0]){
                return a[1]<b[1]?1:-1;
            }else{
                return a[0]>b[0]?1:-1;
            }
        });
        for(int i=0;i<people.length;i++){
            int ind=0;
            int j=0;
            while(res[ind+j]!=null||j<people[i][1]){
                if(res[ind]==null){
                    j++;
                }else{
                    ind++;
                }
            }
            res[ind+j]=people[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] people=GreedyUtils.arr2fromStr("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]");
        new _406().reconstructQueue(people);
    }
}
