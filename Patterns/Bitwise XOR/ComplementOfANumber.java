class ComplementOfANumber {
    public static int bitwiseComplement(int num) {
        int bitCount = 0;
        int n = num;
        while (n>0) {
            bitCount++;
            n = n >> 1;
        }

        int all_bit_sets = (int) Math.pow(2, bitCount) - 1;
        return  num^all_bit_sets;
    }    

    public static void main(String[] args) {
        System.out.println("Bitwise complement is: " + ComplementOfANumber.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + ComplementOfANumber.bitwiseComplement(10));
    }
}