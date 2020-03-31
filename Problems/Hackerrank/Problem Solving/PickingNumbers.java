/*
    	Submissions	Leaderboard	Discussions	Editorial
    Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is less than or equal to . For example, if your array is , you can create two subarrays meeting the criterion:  and . The maximum length subarray has  elements.

    Function Description

    Complete the pickingNumbers function in the editor below. It should return an integer that represents the length of the longest array that can be created.

    pickingNumbers has the following parameter(s):

a: an array of integers
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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        Collections.sort(a);
        System.out.println(a);
        int actualCount = Integer.MIN_VALUE;
        for (int i=0; i<a.size(); i++) {
            int currentCounter = 0;
            int currentMax = a.get(i) + 2;
            while((i < a.size() && a.get(i) < currentMax)) {
                System.out.println(currentMax + " : " + a.get(i));
                currentCounter++;
                i++;
            }
            i--; // we need to to do this otherwise we will skip one item , i is incremented in for loop as well
            actualCount = Math.max(currentCounter, actualCount);       
        }

        return actualCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
