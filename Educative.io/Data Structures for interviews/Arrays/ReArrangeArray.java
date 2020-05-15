class CheckReArrange {
    //Re-Arrange Positive and Negative Values of Given Array 
    public static void reArrange(int[] arr) {
        int j = 0; 
        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] < 0) {   // if negative number found
                if (i != j) { 
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++; 
            } 
        } 
    }
}