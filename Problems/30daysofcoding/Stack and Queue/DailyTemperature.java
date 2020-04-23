import java.util.Arrays;
import java.util.Stack;

class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int id = stack.pop();
                ret[id] = i - id;
            }

            stack.push(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        DailyTemperature obj =  new DailyTemperature();
        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}