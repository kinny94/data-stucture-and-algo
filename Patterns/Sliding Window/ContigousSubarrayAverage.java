import java.util.Arrays;

class ContigousSubarrayAverage {
    public double[] findAverage(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int i=0; i<k; i++) {
            windowSum += (double) arr[i];
        }

        result[0] = (double) windowSum/k;
        int index = 1;

        for (int i=k; i<arr.length; i++) {
            windowSum = (double) arr[i] + windowSum - arr[windowStart];
            result[index] = (double) windowSum/k;
            windowStart++;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        ContigousSubarrayAverage obj = new ContigousSubarrayAverage();
        double result[] = obj.findAverage(new int[]{ 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}