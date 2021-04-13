package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyUtils {
    public static int[][] arr2fromStr(String str){
        str=str.substring(2,str.length()-2);

        String[] strs=str.split("],\\[");
        int[][] res=new int[strs.length][];
        for(int i=0;i<strs.length;i++){
            res[i]= Arrays.stream(strs[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        return res;
    }
}
