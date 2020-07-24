import java.util.ArrayList;
import java.util.List;

class EvalutateExpression {
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();

        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i=0; i<input.length(); i++) {
                char ch = input.charAt(i);
                if (!Character.isDigit(ch)) {
                    List<Integer> leftPart = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightPart = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (int part1: leftPart) {
                        for (int part2: rightPart) {
                            if (ch == '+') {
                                result.add(part1 + part2);
                            } else if (ch == '-') {
                                result.add(part1 - part2);
                            } else if (ch == '*') {
                                result.add(part1 * part2);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }    

    public static void main(String[] args) {
        List<Integer> result = EvalutateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);
    
        result = EvalutateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}