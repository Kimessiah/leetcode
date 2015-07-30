public int trap(int[] height) {

	if (height.length == 0) return 0;

	int[] left = new int[height.length];
	int[] right = new int[height.length];

	int leftMax = 0; int rightMax = 0;

   	for (int i = height.length-2; i >=0; i--) {
    		right[i] = Math.max(height[i+1], right[i+1]);
    	}
    
	for (int i = 1; i < height.length; i++) {
		left[i] = Math.max(height[i-1], left[i-1]);
	}

	int water = 0;

	for (int i=0; i< height.length; i++) {
		if (Math.min(left[i], right[i]) - height[i] > 0) {
			water += Math.min(left[i], right[i]) - height[i];
		}
	}
	return water;
}