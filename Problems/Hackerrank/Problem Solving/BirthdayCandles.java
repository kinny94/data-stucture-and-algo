/**
 * You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for 
 * each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. 
 * Your task is to find out how many candles she can successfully blow out.
    For example, if your niece is turning  years old, and the cake will have  candles of height , , , , 
    she will be able to blow out  candles successfully, since the tallest candles are of height  and there are  such candles.
    Function Description

    Complete the function birthdayCakeCandles in the editor below. It must return an integer representing the number 
    of candles she can blow out.

    birthdayCakeCandles has the following parameter(s):

    ar: an array of integers representing candle heights
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] arr) {

        int max = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == max) {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
