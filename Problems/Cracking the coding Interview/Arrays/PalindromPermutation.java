class PalindromPermutation {

    private int getCharacterNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    private int[] buildCharacterFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') - 1];

        for (char c: phrase.toCharArray()) {
            int x = getCharacterNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    public boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharacterFrequencyTable(phrase);
        boolean foundOdd = false;
        for (int count: table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromPermutation obj = new PalindromPermutation();
        System.out.println(obj.isPermutationOfPalindrome("Tact Coa"));
    }
} 