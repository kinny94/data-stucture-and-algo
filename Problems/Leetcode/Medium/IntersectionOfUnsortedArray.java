import java.util.*;

public class IntersectionOfUnsortedArray {
    
    // Prints intersection of arr1[0..m-1] and arr2[0..n-1] 
    static void printIntersection(int arr1[], int arr2[]) 
    { 
        HashSet<Integer> hs = new HashSet<>(); 
        HashSet<Integer> hs1 = new HashSet<>(); 
        
        for (int i = 0; i < arr1.length; i++)  
        hs.add(arr1[i]); 
        
        for (int i = 0; i < arr2.length; i++)  
        if (hs.contains(arr2[i])) 
        System.out.print(arr2[i] + " "); 
    } 
    
    public static void main(String[] args)  
    { 
        int arr1[] = {7, 1, 5, 2, 3, 6}; 
        int arr2[] = {3, 8, 6, 20, 7}; 
        
        System.out.println("Intersection of two arrays is : "); 
        printIntersection(arr1, arr2);         
    } 
}