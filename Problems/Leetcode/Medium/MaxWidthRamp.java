import java.util.*;

class MaxWidthRamp {

    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack();
        int result = 0;

        System.out.println(Arrays.toString(A));
        for (int i=0; i<A.length; i++) {

            if (!stack.isEmpty()) {
                System.out.print(stack.peek() + " : " + i + " ===> ");
                System.out.print(A[stack.peek()] + " : " + A[i]);
                System.out.println();
            }

            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.add(i);
            }
        }

        System.out.println(stack);

        for (int i=A.length - 1; i>result; i--) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                result = Math.max(result, i - stack.pop());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxWidthRamp obj = new MaxWidthRamp();
        int[] a = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(obj.maxWidthRamp(a));
    }
}