package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> lst=new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            int tmp=0;

            if(nums1[i]>=nums2[j]){
                tmp=nums1[i];
                i++;
            }else{
                tmp=nums2[j];
                j++;
            }
            modLst(lst,tmp,k);
        }
        int[] nums=nums1;
        int tail=i;
        if(i==nums1.length){
            nums=nums2;
            tail=j;
        }
        while(tail<nums.length){
            modLst(lst,nums[tail],k);
        }
        return lst.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void modLst(List<Integer> lst,int n,int k){
       if(lst.size()<k){
           lst.add(n);
           return;
       }
       for(int i=0;i<k-1;i++){
           if(lst.get(i)<lst.get(i+1)){
               lst.remove(i);
               lst.add(n);
               return;
           }
       }
       if(n>lst.get(k-1)){
           lst.remove(k-1);
           lst.add(n);
       }
    }

    public static void main(String[] args) {
        _321 test=new _321();
        int[] nums1={3, 4, 6, 5};
        int[] nums2={9, 1, 2, 5, 8, 3};

        test.maxNumber(nums1,nums2,5);
    }
}
