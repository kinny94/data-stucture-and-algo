/**
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from  to  for three categories: problem clarity, originality, and difficulty.

    We define the rating for Alice's challenge to be the triplet , and the rating for Bob's challenge to be the triplet .

    Your task is to find their comparison points by comparing  with ,  with , and  with .

    If , then Alice is awarded  point.
    If , then Bob is awarded  point.
    If , then neither person receives a point.
    Comparison points is the total points a person earned.

    Given  and , determine their respective comparison points.

    For example,  and . For elements , Bob is awarded a point because . 
    For the equal elements  and , no points are earned. Finally, for elements ,  
    so Alice receives a point. Your return array would be  with Alice's score first and Bob's second.

    Function Description
    Complete the function compareTriplets in the editor below. 
    It must return an array of two integers, the first being Alice's score and the second being Bob's.
    compareTriplets has the following parameter(s):

    a: an array of integers representing Alice's challenge rating
    b: an array of integers representing Bob's challenge rating
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

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> points = new ArrayList<Integer>(Arrays.asList(0, 0));
        for(int i=0; i<a.size(); i++) {
            if(a.get(i) > b.get(i)) {
                points.set(0, points.get(0) + 1); 
            }
            if (a.get(i) < b.get(i)) {
                points.set(1, points.get(1) + 1);
            }
        }

        return points;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
