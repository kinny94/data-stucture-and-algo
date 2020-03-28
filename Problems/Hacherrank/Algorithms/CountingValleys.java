/**
 *  
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. 
 * During his last hike he took exactly  steps. For every step he took, he noted if it was an uphill, , or a downhill,  
 * step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude. 
 * We define the following terms:
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending 
 * with a step down to sea level. 
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending 
 * with a step up to sea level. 
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 * For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high. Finally, he returns to sea level and ends his hike.
 * Function Description
 * Complete the countingValleys function in the editor below. 
 * It must return an integer that denotes the number of valleys Gary traversed.
 * ountingValleys has the following parameter(s):
 * n: the number of steps Gary takes
 * s: a string describing his path
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'U') {
                level++;
            } else {
                if (level == 0) {
                    valleys++;
                } 
                level--;
            }
        }

        return valleys;
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
