import java.util.List;
import java.util.Arrays;

class RotateArrayByN {
    
    public static void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
    
    public static void rotateArray(List<Integer> arr, int n) {
        int len = arr.size();
        n = n % len;
        if (n < 0) {
            n = n + len;
        }
        
        reverse(arr, 0, len - 1);
        reverse(arr, 0, n-1);
        reverse(arr, n, len - 1);
    }
    
    public static void main(String []args){
        List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n"+arr);
        rotateArray(arr, 2);
        System.out.println("Array After Rotation\n"+arr);
    }
}