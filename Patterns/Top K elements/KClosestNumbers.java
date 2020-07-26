import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Entry {
    int key;
    int value;
    
    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestNumbers {
    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X);
        int low = index - K;
        int high = index + K;
        low = Math.max(low, 0);
        high = Math.min(high, arr.length - 1);
        
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((a, b) -> a.key - b.key);
        for (int i=low; i<=high; i++) {
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<K; i++) {
            result.add(arr[minHeap.poll().value]);
        }
        
        Collections.sort(result);
        
        return result;
    }   
    
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
            return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > 0) {
            return low - 1;
        }
        return low;
    }
    public static void main(String[] args) {
        List<Integer> result = KClosestNumbers.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);
        
        result = KClosestNumbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);
        
        result = KClosestNumbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}