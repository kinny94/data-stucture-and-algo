class CheckLarge {
	public static int[] findKLargest(int[] arr,int k) 
  {
		int[] result = new int[k]; 
    // Write - Your - Code    
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int i=0; i<arr.length; i++) {
      queue.add(arr[i]);
    }

    int index = 0;
    while (index < k) {
      result[index] = queue.remove();
      index++;
    }

    return result;
	} 
}