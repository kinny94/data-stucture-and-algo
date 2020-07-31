import java.util.Arrays;
import java.util.List;

class RotateAnArrayByelements {
    
    public static void reverseArray(List<Integer> arr, int start, int end) {
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

        reverseArray(arr, 0, len - 1);
        reverseArray(arr, 0, n-1);
        reverseArray(arr, n, len-1);
    }    

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n"+arr);
        rotateArray(arr, 2);
        System.out.println("Array After Rotation\n"+arr);
    }
}