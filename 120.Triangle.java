// Top-down: Time O(n^2)   Space O(n)
public int minimumTotal(List<List<Integer>> triangle) {

	if (triangle == null || triangle.size() == 0) return 0;

	int[] res = new int[triangle.size()];
	res[0] = triangle.get(0).get(0);

	for (int i = 1; i < triangle.size(); i++) {

		res[i] = res[i-1] + triangle.get(i).get(i);
		for (int j = i-1; j >= 1; j--) {
			res[j] = Math.min(res[j], res[j-1]) + triangle.get(i).get(j);
		} 
		res[0] = res[0] + triangle.get(i).get(0);
	}

	int min = res[0];
	for (int i = 1; i < res.length; i++) {
		if (res[i] < min) {
			min = res[i];
		}
	}
	return min;
}

// Bottom-up: Time O(n^2)   Space O(n)
public int minimumTotal(List<List<Integer>> triangle) {

	if (triangle == null || triangle.size() == 0) return 0;

	int[] res = new int[triangle.size()];

	for (int i = 0; i < triangle.size(); i++) {
		res[i] = triangle.get(triangle.size()-1).get(i);
	}

	for (int i = triangle.size()-2; i >= 0; i--) {
		for (int j = 0; j <= i; j++) {
			res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j); 
		}
	}
	res[0];
}