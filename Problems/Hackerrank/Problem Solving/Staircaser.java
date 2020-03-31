/**
 *    #
     ##
    ###
   ####
    Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. 
    The last line is not preceded by any spaces.

    Write a program that prints a staircase of size .

    Function Description

    Complete the staircase function in the editor below. It should print a staircase as described above.

    staircase has the following parameter(s):

    n: an integer
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i+j >= n-1) {
                    System.out.print('#');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
