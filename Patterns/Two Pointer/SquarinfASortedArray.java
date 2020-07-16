class SquarinfASortedArray {
    public int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] sqaures = new int[n];
        int highestSqareIdx = n - 1;
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int leftSqaure = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSqaure > rightSquare) {
                sqaures[highestSqareIdx] = leftSqaure;
                highestSqareIdx--;
                left++; 
            } else {
                sqaures[highestSqareIdx] = rightSquare;
                highestSqareIdx--;
                right--;
            }
        }

        return sqaures;
    }   

    public static void main(String[] args) {
        SquarinfASortedArray obj = new SquarinfASortedArray();
        int[] result = obj.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = obj.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}