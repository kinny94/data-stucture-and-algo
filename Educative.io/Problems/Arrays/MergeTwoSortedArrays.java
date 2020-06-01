import java.util.Arrays;

class MergeTwoSortedArrays { 
    // merge arr1 and arr2 into a new result array 
    public static int[] mergeArrays(int[] arr1, int[] arr2) {  
        
        int totalLength = arr1.length + arr2.length;
        int[] result = new int[totalLength];
        
        int first_pointer = 0;
        int second_pointer = 0;
        
        for (int i=0; i<totalLength; i++) {
            if (arr1[first_pointer] < arr2[second_pointer]) {
                result[i] = arr1[first_pointer];
                if (first_pointer + 1 != arr1.length - 1) {
                    first_pointer++;
                }
            } else {
                System.out.println(arr2[second_pointer]);
                if (second_pointer + 1 != arr2.length - 1) {
                    second_pointer++;
                }
            }
        }
        
       return result;

    } 
    
    public static void main(String args[]) {
        
        int[] arr1 = {1,12,14,17,23}; // creating a sorted array called arr1
        int[] arr2 = {11,19,27};  // creating a sorted array called arr2
        
        int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays
        
        System.out.print("Arrays after merging: ");
        for(int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }
}