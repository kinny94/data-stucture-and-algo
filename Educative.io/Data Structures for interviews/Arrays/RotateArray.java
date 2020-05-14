class CheckRotateArray
{
  //Rotates given Array by 1 position
  public static void rotateArray(int[] arr) {

    //Store Last Element of Array.
    //Start from last and Right Shift the Array by one.
    //Store the last element saved to be the first element of array.
    int lastElement = arr[arr.length - 1];

    for (int i = arr.length - 1; i > 0; i--) {

      arr[i] = arr[i - 1];
    }

    arr[0] = lastElement;
  }
} //end of rotateArray