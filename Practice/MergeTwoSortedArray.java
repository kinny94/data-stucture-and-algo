import java.util.*;

public class MergeTwoSortedArray {

    public int[] sortedArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index = 0;
        int aPointer = 0;
        int bPointer = 0;
        
        while (aPointer < a.length && bPointer < b.length) {
            
            if (a[aPointer] < b[bPointer]) {
                result[index] = a[aPointer];
                index++;
                aPointer++;
            } else {
                result[index] = b[bPointer];
                index++;
                bPointer++;
            }

            while (aPointer < a.length) {
                result[index] = a[aPointer];
                aPointer++;
                index++;
            }

            while (bPointer < b.length) {
                result[index] = b[bPointer];
                bPointer++;
                index++;
            } 
        }

        return result;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};

        MergeTwoSortedArray obj = new MergeTwoSortedArray();
        System.out.println(Arrays.toString(obj.sortedArray(a, b)));
    }
}