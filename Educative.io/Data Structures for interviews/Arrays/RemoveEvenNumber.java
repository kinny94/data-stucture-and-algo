class CheckRemoveEven {

	public static int[] removeEven(int[] arr) {

        int countOdd = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] % 2 != 0) {
                countOdd++;
            }
        }

        int[] result = new int[countOdd];
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[index] = arr[i];
                index++;
            }
        }
		// Write - Your - Code- Here
		return result; // change this and return the correct result array
	}
}