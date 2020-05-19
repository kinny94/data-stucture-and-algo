class BinarySearch{
    static int binSearch(int[] a, int key) {
        return search(0, a.length - 1, key, a);
    }
    
    private static int search(int leftIndex, int rightIndex, int key, int[] a) {
        
        if (leftIndex > rightIndex) {
            return -1;
        }
        int mid = (leftIndex + rightIndex) / 2;
        if (a[mid] == key) {
            return mid;
        } else if (key > a[mid]) {
            return search(mid + 1, rightIndex, key, a);
        } else {
            return search(leftIndex, mid - 1, key, a);
        }
    }
}  