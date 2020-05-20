class PowerNum{  
    static double powerRec(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        
        double temp = powerRec(x, n/2);
        if (n % 2 == 0)  {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
    
    static double power(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }
        
        double result = powerRec(x, n);
        
        if (isNegative) {
            return 1 / result;
        }
        
        return result;
    }
    
    public static void main(String[] args) {   
        System.out.println("Power(0, 0) = " + Double.toString(power(0,0)));
        System.out.println("Power(2, 5) = " + Double.toString(power(2,5)));
        System.out.println("Power(3, 4) = " + Double.toString(power(3,4)));
        System.out.println("Power(1.5, 3) = " + Double.toString(power(1.5,3)));
        System.out.println("Power(2, -2) = " + Double.toString(power(2,-2)));
    }
}