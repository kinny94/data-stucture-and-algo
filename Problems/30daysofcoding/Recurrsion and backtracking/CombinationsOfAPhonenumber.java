import java.util.*;

class CombinationsOfAPhonenumber {

    public List<String> calculateCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] mappings = {"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        permuteCombinations(result, digits, "", 0, mappings);
        return result;
    }

    public void permuteCombinations(List<String> result, String digits, String current, int index, String[] mappings) {
        
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mappings[digits.charAt(index) - '0'];
        for (int i=0; i<letters.length(); i++) {
            permuteCombinations(result, digits, current + letters.charAt(i), index+1, mappings);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        CombinationsOfAPhonenumber cb = new CombinationsOfAPhonenumber();
        System.out.println(cb.calculateCombinations(digits));
    }

}