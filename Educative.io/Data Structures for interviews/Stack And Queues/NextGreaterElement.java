class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int resultIndex = 0;
        Stack<Integer> stack = new Stack<>(arr.length);
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.top() <= arr[i]) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else
                result[i]  = stack.top();
            stack.push(arr[i]);
        }
        return result;
    }

	public static void main(String[] args) 
	{ 
    	int arr[] = {4,6,3,2,8,1,11}; 
		System.out.println(Arrays.toString(arr));
		int result[] = nextGreaterElement(arr); 
		System.out.println(Arrays.toString(result));
	} 
}