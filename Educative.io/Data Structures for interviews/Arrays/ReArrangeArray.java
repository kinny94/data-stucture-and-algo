class CheckReArrange {
    //Re-Arrange Positive and Negative Values of Given Array 
    public static void reArrange(int[] arr) 
    {
        
        int[] newArray = new int[arr.length];
        int newArray_index = 0;
        
        //Fill newArray with Negative Values first.
        //Then Fill it with Postive Values.
        //In the end, insert every element of newArray back into origional arr.
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] < 0) newArray[newArray_index++] = arr[i];
        }
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] > 0) newArray[newArray_index++] = arr[i];
        }
        
        for (int j = 0; j < newArray.length; j++) 
        {
            arr[j] = newArray[j];
        }
    } //end of reArrange()
}