import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {
    String str;
    int openCount; // open parentheses count
    int closeCount; // close parentheses count
    
    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

class BalanceParenthesis {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));

        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) {
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
                }

                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
                }
            }
        }

        return result;
    }


    // backtracking method
    public static List<String> generateParenthesis(int n) {
        
        List<String> results = new ArrayList<>();
        
        if (n == 0) {
            return results;
        }

        generate(results, "", 0, 0, n);
        return results;
    }   

    private static void generate(List<String> results, String currentString, int open, int close, int m) {
        if (currentString.length() == m * 2) {
            results.add(currentString);
            return;
        }

        if (open < m) {
            generate(results, currentString + "(", open + 1, close, m);
        }

        if (close < open) {
            generate(results, currentString + ")", open, close + 1, m);
        }
    }
    
    public static void main(String[] args) {
        List<String> result = BalanceParenthesis.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);
    
        result = BalanceParenthesis.generateParenthesis(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}