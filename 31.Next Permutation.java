/* 1. From right to left, find the first element (Partition Number) which violate increase trend, array[i − 1] < array[i].
** 2. From right to left, find the first element wihch larger than Partition Number, array[j] > array[i - 1]
** 3. Swap array[j] and array[i − 1].
** 4. Reverse the suffix starting at array[i].
** http://www.nayuki.io/page/next-lexicographical-permutation-algorithm 
 */

public void nextPermutation(int[] nums) {

	if (nums.length == 0) return;

	int i = nums.length - 1;
	while (i > 0 && nums[i-1] >= nums[i])
		i--;

	int j = nums.length - 1;
	if (i != 0) {
		while(j >0 && nums[j] <= nums[i-1]) 
			j--;

		// Swap the pivot with j
	    int temp = nums[i - 1];
	    nums[i - 1] = nums[j];
	    nums[j] = temp;
	}

    // Reverse the suffix
    j = nums.length - 1;
    while (i < j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    	i++;
    	j--;
    }
}