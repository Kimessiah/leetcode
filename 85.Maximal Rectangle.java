// Time O(m*n)   Space O(n)
public int maximalRectangle(char[][] matrix) {

	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

	int[] height = new int[matrix[0].length];
	int maxArea = 0;

	for (int i = 0; i< matrix.length; i++) {

		for (int j = 0; j < matrix[0].length; j++) {
			height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
		}
		maxArea = Math.max(maxArea, height);
	}
	return maxArea;
}

int largestRectangleArea(int[] height) {

	if (height == null || height.length == 0) return 0;

	LinkedList<Integer> stack = new LinkedList<Integer>();

	int maxArea = 0;

	for (int i = 0; i < height.length; i++) {

		while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {

			int index = stack.pop();
			int area = stack.isEmpty() ? i*height[index] : (i-stack.peek()-1)*height[index];
			maxArea = Math.max(maxArea, area);
		}
		stack.push(i);
	}

	while (!stack.isEmpty()) {

		int index = stack.pop();
		int area = stack.isEmpty() ? height.length*height[index] : (height.length-stack.peek()-1)*height[index];
		maxArea = Math.max(maxArea, area);
	}
    return maxArea;
}