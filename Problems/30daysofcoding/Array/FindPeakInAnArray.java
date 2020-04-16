class FindPeakInAnArray {
    public int findPeak(int[] arr) {
        int mid = arr.length/2;
        return binarySearch(arr, 0, arr.length);
    }

    private static int binarySearch(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
            return arr[mid];
        } else if (arr[mid - 1] > arr[mid]) {
            if (arr[mid - 1] < 0) {
                return arr[0];
            }
            return binarySearch(arr, 0, mid-1);
        } else if (arr[mid + 1] > arr[mid]) {
            if (mid + 1 > arr.length -1) {
                return arr[end];
            }
            return binarySearch(arr, mid+1, end);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 10, 15, 25, 30, 45, 65, 50, 35, 1};
        FindPeakInAnArray find = new FindPeakInAnArray();
        System.out.println(find.findPeak(a));
    }
}