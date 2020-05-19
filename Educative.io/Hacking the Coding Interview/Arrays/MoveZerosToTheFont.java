import java.util.Arrays;

class MoveZerosToTheFont {
    
    public static void moveZerosToLeft(int[] A) {
        if (A.length < 1) {
            return;
        }
        
        int writeIndex = A.length - 1;
        int readIndex = A.length - 1;
        
        while(readIndex >= 0) {
            if (A[readIndex] != 0) {
                A[writeIndex] = A[readIndex];
                writeIndex--;
            }
            readIndex--;
        }
        
        while(writeIndex >= 0) {
            A[writeIndex] = 0;
            writeIndex--;
        }
    }
    public static void main(String[] args) {
        int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));
        
        moveZerosToLeft(v);
        
        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }
    
}