class SortStack {
    public void sort(Stack<Integer> stack) {
        Stack<Integer> r = new Stack<Integer>();

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            while(!r.isEmpty() && r.peek() > temp) {
                stack.push(r.pop());
            }

            r.push(temp);
        }

        while(!r.isempty()) {
            stack.push(r.pop());
        }
    }
}