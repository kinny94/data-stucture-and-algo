import java.util.Arrays;

class ContigousSubArrayAverage {
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];

        int sum = 0;
        for (int i=0; i<K; i++) {
            sum += arr[i];
        }

        result[0] = (double) sum / K;
        int resultIndex = 1;

        for (int i=K; i<arr.length; i++) {
            sum = sum - arr[i - K] + arr[i];
            result[resultIndex] = (double) (sum)/K;
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = ContigousSubArrayAverage.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}