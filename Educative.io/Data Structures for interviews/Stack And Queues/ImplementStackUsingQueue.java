class ImplementStackUsingQueue <V> {
	//We can use 2 stacks for this purpose, stack1 to store original values
	//and stack2 which will help in dequeue operation.
    Stack<V> stack1;
    Stack<V> stack2;

    public QueueWithStack(int maxSize){
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }
    public boolean isEmpty(){
      return (stack1.isEmpty() && stack2.isEmpty());
    }
    public void enqueue(V value){
        stack1.push(value);
    }
    public V dequeue(){
        //return null if both the stacks are empty 
        if (isEmpty()){
          return null;
        }
        else if (stack2.isEmpty()){ 
          //if stack2 is empty, we pop all the elements
			    //from stack1 and push them to the stack2
          while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
          }
          //finally, we return the top of stack2
          return stack2.pop();
        }
        else{ 
          //if none of the above conditions are true
          //we will simply return the top of stack2
          return stack2.pop();
        }
    }

}