class SquareRoot{
    private static final double EPSILON = 0.000000000000001;
    
    public static double squareRoot(double num) {
        double low = 0;
        
        
        // square root can never be more than 
        // half of number except if number is <= 1
        // so square root of any number always lie
        // between 0 and 1 + (num / 2)
        double high = 1 + num/2;
        
        while (low < high) {
            
            double mid = (low + high) / 2;
            double sqr = mid * mid;
            
            // we can't do a == b for doubles because
            // of rounding errors, so we use error threshold
            // EPSILON. Two doubles a and b are equal if 
            //  abs(a-b) <= EPSILON
            
            double diff = Math.abs(num - sqr);
            
            if (diff <= EPSILON) {
                return mid;
            }
            
            if (sqr < num) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        double [] arr = {16, 17, 2.25};
        for (double i : arr)
        System.out.println("Square root of " + i + " is " + squareRoot(i));
    }
}  