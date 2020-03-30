/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 * For example, the square matrix  is shown below:

    1 2 3
    4 5 6
    9 8 9  
T   he left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .

    Function description

    Complete the  function in the editor below. It must return an integer representing the absolute diagonal difference.

    diagonalDifference takes the following parameter:

    arr: an array of integers .
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
        int rightDiagonalSum = 0;
        int leftDiagonalSum = 0;

        for(int i=0; i<arr.size(); i++) {
            rightDiagonalSum += arr.get(i).get(i);
        }

        for(int i=0; i<arr.size(); i++) {
            leftDiagonalSum += arr.get(i).get(arr.size() - 1 - i);
        }

        return Math.abs(rightDiagonalSum - leftDiagonalSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
