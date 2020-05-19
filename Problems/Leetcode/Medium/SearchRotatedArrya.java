class Solution {
    public int search(int[] nums, int target) {
          return binarySearch(nums, 0,  nums.length - 1, target);
    }
    
    public int binarySearch(int[] arr, int start, int end, int key) {
        // assuming all the keys are unique.

        if (start > end) {
          return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) {
           return mid;
        }

        if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
          return binarySearch(arr, start, mid - 1, key);
        }

        else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
          return binarySearch(arr, mid + 1, end, key);
        }

        else if (arr[end] <= arr[mid]) {
          return binarySearch(arr, mid + 1, end, key);
        }

        else if (arr[start] >= arr[mid]) {
          return binarySearch(arr, start, mid - 1, key);
        }

        return -1;
    }
}