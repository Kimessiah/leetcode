// Time O(n)
public int[] twoSum(int[] numbers, int target) {

	if (numbers == null || numbers.length < 2) {
		throw new IllegalArgumentException("No two sum solution");
	}

	int start = 0;
	int end = numbers.length - 1;

	while (start < end) {
		int sum = numbers[start] + numbers[end];
		if (sum == target) {
			return new int[]{start+1, end+1};
		} else if (sum < target) {
			start++;
		} else {
			end--;
		}
	}
	throw new IllegalArgumentException("No two sum solution");
}

// Binary Search
public int[] twoSum(int[] numbers, int target) {

	if (numbers == null || numbers.length < 2) {
		throw new IllegalArgumentException("No two sum solution");
	}

	for (int i = 0; i < numbers.length-1; i++) {

		int j = find(numbers, target - numbers[i], i+1);
		if (j != -1) {
			return new int[]{i+1, j+1};
		}
	}
	throw new IllegalArgumentException("No two sum solution");
}

int find(int[] numbers, int key, int start) {

	int left = start;
	int right = numbers.length-1;

	while (left + 1 < right) {
		int mid = (left + right) / 2;

		if (numbers[mid] == key) {
			return mid;
		} else if (numbers[mid] < key) {
			left = mid;
		} else {
			right = mid;
		}
	}

	if (numbers[left] == key) return left;
	if (numbers[right] == key) return right;

	return -1;
}