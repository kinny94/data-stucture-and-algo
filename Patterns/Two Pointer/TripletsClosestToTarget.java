import java.util.Arrays;

class TripletsClosestToTarget {
    
    public int searchTriplet(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return -1;
        }

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            
            while (left < right) {
                int targetDiff = target - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) {
                    return target - targetDiff;
                }

                if (Math.abs(targetDiff) < Math.abs(smallestDifference) || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference)) {
                    smallestDifference = targetDiff;
                }

                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return target - smallestDifference;
    }

    public static void main(String[] args) {
        TripletsClosestToTarget obj = new TripletsClosestToTarget();
        System.out.println(obj.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(obj.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(obj.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
        System.out.println(obj.searchTriplet(new int[] { 1,2,5,10,11 }, 12));
    }
}