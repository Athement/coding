package recurse;

import java.util.ArrayList;
import java.util.List;

public class _60 {
    //    回溯
//    String res="";
//    int count=0;
//    public String getPermutation(int n, int k) {
//        int arr[] = new int[n];
//        count=k;
//        permutate(arr,n,"");
//        return res;
//    }
//
//    void permutate(int[] arr, int level,String str) {
//        if(!res.isEmpty()){
//            return;
//        }
//        if(level==0){
//            if(--count==0){
//                res=str;
//            }
//        }
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==0){
//                arr[i]=1;
//                permutate(arr,level-1,str+(i+1));
//                arr[i]=0;
//            }
//        }
//    }
    //math
    public String getPermutation(int n, int k) {
        List<Integer> lst=new ArrayList<>();
        String res="";
        int fac=1;
        for(int i=0;i<n;i++){
            lst.add(i+1);
            fac*=i+1;
        }
        k--;
        while(n>0){
            fac/=n;
            int index=k/fac;
            k%=fac;
            res+=lst.remove(index);
            n--;
        }
        return res;
    }
}
