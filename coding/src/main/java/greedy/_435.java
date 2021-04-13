package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class _435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        int res=0;
        Arrays.sort(intervals,(int[] a,int[] b)->{
            if(a[0]==b[0]){
                return a[1]>b[1]?1:-1;
            }else{
                return a[0]>b[0]?1:-1;
            }
        });
        ArrayList<int[]> lst=new ArrayList<>(Arrays.asList(intervals));
        int[] pre=lst.get(0);
        lst.remove(0);
        while(!lst.isEmpty()){
            int[] cur=lst.get(0);
            lst.remove(0);
            if(cur[0]<pre[1]){
                res++;
                if(cur[1]>pre[1]){
                    //删除cur
                    continue;
                }
                //删除pre，pre=cur；
            }
            //处理下一个节点
            pre=cur;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals=GreedyUtils.arr2fromStr("[[1,2],[2,3],[3,4],[1,3]]");
        System.out.println(new _435().eraseOverlapIntervals(intervals));
    }
}
