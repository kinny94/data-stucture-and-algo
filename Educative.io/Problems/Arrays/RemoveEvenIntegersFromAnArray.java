class RemoveEvenIntegersFromAnArray {
    
    public static int[] removeEven(int[] arr) {

        int oddElements = 0;

        for (int item: arr) {
            if (item %  2 != 0) {
                oddElements++;
            }
        }

        int[] result = new int[oddElements];
        int index = 0;

        for (int item: arr) {
            if (item % 2 != 0) {
                result[index] = item;
                index++;
            }
        }

        return result;
    }

    public static void main(String args[]) {
  
        int size = 10;
        int[] arr = new int[size]; //declaration and instantiation 
      
        System.out.print("Before removing Even Numbers: "); 
        for (int i = 0; i < arr.length; i++) {
          arr[i] = i; // assigning values
          System.out.print(arr[i] +  " ");
        }
        System.out.println();
      
        int[] newArr =  removeEven(arr); // calling removeEven
      
        System.out.print("After removing Even Numbers: "); 
        for (int i = 0; i < newArr.length; i++) {
          System.out.print(newArr[i] +  " "); // prinitng array
        }
      }
}