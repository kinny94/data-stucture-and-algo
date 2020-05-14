class SecondMaximumInteger {
    //Returns second maximum value from given Array 
  public static int findSecondMaximum(int[] arr) {

    int max = -214748364;
    int secondmax = -214748364;

    // Keep track of Maximum value, whenever an array index is greater
    // than current Maximum value then make that max value 2nd max value and
    // make that index value maximum value  
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondmax = max;
        max = arr[i];
      }
      else if (arr[i] > secondmax) {
        secondmax = arr[i];
      }
    }//end of for-loop

    return secondmax;
  }
}