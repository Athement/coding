package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        int res=1;
        Arrays.sort(points,(int[]a,int[]b)->{
            if(a[0]==b[0]){
                return a[1]>b[1]?1:-1;
            }{
                return a[0]>b[0]?1:-1;
            }
        });
        List<int[]> pLst= new ArrayList<>(Arrays.asList(points));
        int prePoint[]=pLst.get(0);
        pLst.remove(0);
        while(!pLst.isEmpty()){
            int point[]=pLst.get(0);
            pLst.remove(0);
            if(point[0]<=prePoint[1]){
                if(point[1]>=prePoint[1]){
                    prePoint=new int[]{point[0],prePoint[1]};
                }else{
                    prePoint=new int[]{point[0],point[1]};
                }
            }else{
                prePoint=point;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] points=GreedyUtils.arr2fromStr("[[-2147483646,-2147483645],[2147483646,2147483647]]");
        new _452().findMinArrowShots(points);
    }
}
