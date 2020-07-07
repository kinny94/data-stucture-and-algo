import java.util.ArrayList;
import java.util.List;

class LettersCombinationOfAPhone {

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        
        if (digits.length() == 0) {
            return results;
        }

        String[] mappings = {"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        permuteCombinations(results, digits, "", 0, mappings);
        return results;
    }    

    private void permuteCombinations(List<String> results, String digits, String currentString, int index, String[] mappings) {
        if (digits.length() == index) {
            results.add(currentString);
            return;
        }

        String letters = mappings[digits.charAt(index) - '0'];
        for (int i=0; i<letters.length(); i++) {
            permuteCombinations(results, digits, currentString + letters.charAt(i), index + 1, mappings);
        }
    }
}