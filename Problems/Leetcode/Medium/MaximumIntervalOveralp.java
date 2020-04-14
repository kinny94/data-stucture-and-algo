import java.util.*;

/*
    1). Create an auxiliary array used for storing dynamic data of starting and ending points.

    2). Loop through the whole array of elements and increase the value at the starting point by 1 and similarly decrease the value after ending point by 1.
    [Here we use the expressions “x[start[i]]-=1” and “x[end[i]+1]-=1”]

    3). While looping, after calculating the auxiliary array: permanently add the value at current index and check for the maximum valued index traversing from left to right.
*/

public class MaximumIntervalOveralp {
    
    public static void maxOverlap(int []start,int [] end ,int n) 
    { 
        // Finding maximum starting time 
        int maxa = Arrays.stream(start).max().getAsInt(); 
        
        // Finding maximum ending time 
        int maxb = Arrays.stream(end).max().getAsInt(); 
        
        int maxc = Math.max(maxa,maxb);  
        
        int []x = new int[maxc + 2]; 
        Arrays.fill(x, 0); 
        
        int cur=0,idx=0; 
        
        // reating an auxiliary array 
        for(int i = 0; i < n; i++) 
        { 
            // Lazy addition 
            ++x[start[i]]; 
            --x[end[i]+1]; 
        } 
        
        int maxy=Integer.MIN_VALUE; 
        
        //Lazily Calculating value at index i 
        for(int i = 0; i <= maxc; i++)  
        { 
            cur+=x[i]; 
            if(maxy < cur) 
            { 
                maxy = cur; 
                idx = i; 
                
            }          
        } 
        System.out.println("Maximum value is:"+ 
        maxy+" at position: "+idx+""); 
        
    }  
    public static void main(String[] args) {
        int [] start = new int[]{13, 28, 29, 14, 40, 17, 3 }; 
        int [] end = new int[]{107, 95, 111, 105, 70, 127, 74}; 
        int n = start.length; 
      
        maxOverlap(start,end,n); 
    }
}