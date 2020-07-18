import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QuadruplesSumToTarget {
    private List<List<Integer>> searchQuadruples(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruples = new ArrayList<>();

        for (int i=0; i<arr.length - 1; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }

            for (int j= i + 1; j<arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                searchPair(arr, target, i , j, quadruples);
            }
        }

        return quadruples;
    }    

    private void searchPair(int[] arr, int target, int first, int second, List<List<Integer>> quadruples) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == target) {
                quadruples.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;

                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }

                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        QuadruplesSumToTarget obj = new QuadruplesSumToTarget();
        System.out.println(obj.searchQuadruples(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(obj.searchQuadruples(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
      }
}