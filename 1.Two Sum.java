// O(n) with hash table
public int[] twoSum(int[] numbers, int target) {

	Map<Integer, Integer> hash = new HashMap<>();

	for (int i=0; i<numbers.length; i++) {
		int n = numbers[i];
		if (hash.containsKey(n)) {
			return new int[]{hash.get(n), i+1};
		} else {
			hash.put(target-n, i+1);
		}
	}
	return null;
}

// O(nlogn) with sorting
public int[] twoSum(int[] numbers, int target) {

	int[] sorted = new int[numbers.length];
	System.arraycopy(numbers, 0, sorted, 0, numbers.length);
	Arrays.sort(sorted);
	int start = 0;
	int end = sorted.length - 1;
	int number1 = 0, number2 = 0;
	int index1 = -1, index2 = -1;

	while (start < end) {
		int sum = sorted[start] + sorted[end];
		if (sum < target) {
			start++;
		} else if (sum > target) {
			end--;
		} else {
			number1 = sorted[start];
			number2 = sorted[end];
			break;
		}
	}

	for (int i=0; i<numbers.length; i++) {
		if (index1 == -1 && numbers[i] == number1) {
			index1 = i+1;
		} else if (index2 == -1 && numbers[i] == number2) {
			index2 = i+1;
		}
	}

	if (index1 < index2) {
		return new int[]{index1, index2};
	} else {
		return new int[]{index2, index1};
	}
}