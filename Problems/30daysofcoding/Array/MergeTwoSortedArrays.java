import java.util.*;

class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        m--; // pointer to the biggest element in nums1
        n--; // pointer to the biggest element in nums2
        
        while( m>=0 && n>=0) {
            if (nums1[m] > nums2[n]) {
                nums1[count] = nums1[m];
                count--;
                m--;
            } else {
                nums1[count] = nums2[n];
                count--;
                n--;
            }
        }

        while(n >= 0) {
            nums1[count] = nums2[n];
            count--;
            n--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge.merge(a, 3, b, 3);
    }
}