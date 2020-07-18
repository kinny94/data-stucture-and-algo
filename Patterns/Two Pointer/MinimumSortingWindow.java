class MinimumSortingWindow {
    public int sort (int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }

        if (low == arr.length - 1) {
            return 0;
        }

        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        int subArrayMax = Integer.MIN_VALUE;
        int subArrayMin = Integer.MAX_VALUE;

        for (int i=low; i<=high; i++) {
            subArrayMax = Math.max(subArrayMax, arr[i]);
            subArrayMin = Math.min(subArrayMin, arr[i]);
        }

        while (low > 0 && arr[low - 1] > subArrayMin) {
            low--;
        }

        while (high < arr.length - 1 && arr[high + 1] < subArrayMax) {
            high++;
        }

        return high - low + 1;
    }

    public static void main(String[] args) {
        MinimumSortingWindow obj = new MinimumSortingWindow();
        System.out.println(obj.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(obj.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(obj.sort(new int[] { 1, 2, 3 }));
        System.out.println(obj.sort(new int[] { 3, 2, 1 }));
    }
}