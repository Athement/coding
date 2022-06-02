package array_package;

import java.util.Arrays;

public class _04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return find(nums1,0,nums1.length-1,nums2,0,nums2.length-1);
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int
    }

    public static void main(String[] args) {
        _04 test=new _04();
        System.out.println(test.findMedianSortedArrays(new int[]{2,4},new int[]{1,2,3}));
    }

}
