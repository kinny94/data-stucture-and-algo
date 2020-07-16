class PairSum {
    public int[] search(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == k) {
                return new int[]{left, right};
            }

            if (k > currentSum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }    

    public static void main(String[] args) {
        PairSum obj = new PairSum();
        int[] result = obj.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = obj.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}