class checkSmall {

	public static int[] findKSmallest(int[] arr,int k) {

		int[] result = new int[k]; 
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

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
