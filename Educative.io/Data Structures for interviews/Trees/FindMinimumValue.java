class FindMinimumValue {
    public static int findMin(Node root) {
		// Write - Your - Code
		return helper(root);
	}

	private static int helper(Node node) {
		if (node.leftChild == null) {
			return node.getData();
		}

		return helper(node.leftChild);
	}
}