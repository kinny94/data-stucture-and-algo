class SearchRotatedArray {
    static int binarySearchRotated(int[] arr, int key) {
        return binarySearch(arr, 0, arr.length - 1, key);
    }
    
    private static int binarySearch(int[] arr, int leftIndex, int rightIndex, int key) {
        if (leftIndex > rightIndex) {
            return -1;
        }
        
        int mid = (leftIndex + rightIndex) / 2;
        
        if (arr[mid] == key) { 
            return mid;
        }
        
        if (arr[leftIndex] <= arr[mid] && key <= arr[mid] && key >= arr[leftIndex]) {
            return binarySearch(arr, leftIndex, mid - 1, key);
        } else if (arr[mid] <=arr[rightIndex] && key >= arr[mid] && key <= arr[rightIndex]) {
            return binarySearch(arr, mid + 1, rightIndex, key);
        } else if (arr[rightIndex] <= arr[mid]) {
            return binarySearch(arr, mid + 1, rightIndex, key);
        } else if (arr[leftIndex] >= arr[mid]) {
            return binarySearch(arr, leftIndex, mid - 1, key);
        }
        
        return -1;
    } 
    
    public static void main(String []args){
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));
        
        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));    
    }
}