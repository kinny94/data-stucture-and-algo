/**
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
 * Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
 * For example, if the string  and , the substring we consider is , the first  characters of her infinite string. 
 * There are  occurrences of a in the substring.
 * Function Description
 * Complete the repeatedString function in the editor below. It should return an integer representing 
 * the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 * repeatedString has the following parameter(s):
 * s: a string to repeat
 * n: the number of characters to conside
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
   static long repeatedString(String s, long n) {

    long check = 0;
        int i=0,j=0,k=0;
        long count = 0;

        for(i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a')
                count++;
        }

        long div = n/s.length();
        long reminder = n%s.length();

        count = div*count;

        for(i=0; i<reminder; i++){
            if(s.charAt(i) == 'a')
                count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
