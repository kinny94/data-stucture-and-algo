class DivideInteger{
    public static int integerDivide(int A, int B) {
        
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
    
    public static void main(String[] args) {
        System.out.println( "7/2 = " + integerDivide(7, 2));
        System.out.println( "5/4 = " + integerDivide(5, 4));
        System.out.println( "1/3 = " + integerDivide(1, 3));
        System.out.println( "40/5 = " + integerDivide(40, 5));
        System.out.println( "40/4 = " + integerDivide(40, 4));
    }
}  