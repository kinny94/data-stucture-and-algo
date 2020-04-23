class SetOfStacks {
	ArrayList<Stack> sets = new ArrayList<Stack>();
	int counter = 0, capacity = 4;
	Stack<Integer> stack;

	void push(int i) {
		if (counter == capacity || counter == 0) {
			counter = 0;
			stack = new Stack<>();
			sets.add(stack);
		}
		stack.push(i);
		counter++;
	}

	int pop() {
		if(counter == 1)
		{
			counter = capacity;
		}
		else
		  counter--;
		return (Integer) sets.get(sets.size() - 1).pop();
	}
}