class ImplementBinarySearch {
    
    public int binarySearchRec(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        
        int mid = low + ((high - low) / 2);
        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearchRec(a, key, low, mid - 1);
        } else {
            return binarySearchRec(a, key, mid + 1, high);
        }
    }


    public int binSearch(int[] a, int key) {
        return binarySearchRec(a, key, 0, a.length - 1);
    }
    
    public static void main(String[] args) {
        
        ImplementBinarySearch obj = new ImplementBinarySearch();
        int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};

        System.out.println(obj.binSearch(arr, 107));
    }
}