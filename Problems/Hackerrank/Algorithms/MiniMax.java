/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly 
 * four of the five integers. Then print the respective minimum and maximum values as a single line of 
 * two space-separated long integers.

    For example, . Our minimum sum is  and our maximum sum is . We would print

    16 24
    Function Description

    Complete the miniMaxSum function in the editor below. It should print two space-separated integers on one 
    line: the minimum sum and the maximum sum of  of  elements.

    miniMaxSum has the following parameter(s):

    arr: an array of  integers
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < min) { 
                min = arr[i];
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) { 
                max = arr[i];
            }
        }

        long sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        System.out.println((sum-max) + " " + (sum-min));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
