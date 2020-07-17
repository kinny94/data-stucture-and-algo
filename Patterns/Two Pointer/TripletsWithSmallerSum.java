import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TripletsWithSmallerSum {
    public int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            count += searchPair(arr, target - arr[i], i, triplets);
        }

        System.out.println(triplets);
        return count;
    }    

    private int searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets)  {
        int count = 0;
        int left = first + 1;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {

                count += right - left;  
                for (int i=right; i>left; i--) {
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TripletsWithSmallerSum obj = new TripletsWithSmallerSum();
        System.out.println(obj.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(obj.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}