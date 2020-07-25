class MissingNumber {
    public static int findMissingNumber(int[] arr) {
        int num = 0;
        for (int i=0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 2, 6, 4 };
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
    }
}