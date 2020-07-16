class RemoveDuplicates {
    public int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        } 

        return nextNonDuplicate;
    }    

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(obj.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(obj.remove(arr));
    }
}